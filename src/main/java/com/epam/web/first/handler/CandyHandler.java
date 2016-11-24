package com.epam.web.first.handler;

import com.epam.web.first.entity.Candy;
import com.epam.web.first.entity.Chocolate;
import com.epam.web.first.entity.Sweet;
import com.epam.web.first.type.CandyEnum;
import com.epam.web.first.type.ChocolateColor;
import com.epam.web.first.type.SweetType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandyHandler extends DefaultHandler {
    private static final int FIRST_ATTRIBUTE = 0;
    private static final char DASH = '-';
    private static final char UNDERSCORE = '_';

    private Set<Candy> candies;
    private Candy current = null;
    private CandyEnum currentEnum = null;
    private EnumSet<CandyEnum> withText;

    public CandyHandler() {
        candies = new HashSet<>();
        withText = EnumSet.range(CandyEnum.ENERGY, CandyEnum.COCOA_BUTTER);
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (CandyEnum.SWEET.getValue().equals(localName)) {
            current = new Sweet();
            current.setName(attributes.getValue(FIRST_ATTRIBUTE));
        } else if (CandyEnum.CHOCOLATE.getValue().equals(localName)) {
            current = new Chocolate();
            current.setName(attributes.getValue(FIRST_ATTRIBUTE));
        } else {
            String element = localName.replace(DASH, UNDERSCORE).toUpperCase();
            CandyEnum temp = CandyEnum.valueOf(element);
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (CandyEnum.SWEET.getValue().equals(localName) || CandyEnum.CHOCOLATE.getValue().equals(localName)) {
            candies.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        if (currentEnum != null) {
            switch (currentEnum) {
                case ENERGY:
                    current.setEnergy(Double.parseDouble(data));
                    break;
                case PROTEINS:
                    current.getValue().setProteins(Double.parseDouble(data));
                    break;
                case FATS:
                    current.getValue().setFats(Double.parseDouble(data));
                    break;
                case CARBOHYDRATES:
                    current.getValue().setCarbohydrates(Double.parseDouble(data));
                    break;
                case PRODUCTION:
                    current.setProduction(data);
                    break;
                case TYPE:
                    ((Sweet) current).setType(SweetType.valueOf(data.toUpperCase()));
                    break;
                case WATER:
                    ((Sweet) current).getIngredients().setWater(Double.parseDouble(data));
                    break;
                case SUGAR:
                    if (current instanceof Sweet) {
                        ((Sweet) current).getIngredients().setSugar(Double.parseDouble(data));
                    } else {
                        ((Chocolate) current).getIngredients().setSugar(Double.parseDouble(data));
                    }
                    break;
                case FRUCTOSE:
                    ((Sweet) current).getIngredients().setFructose(Double.parseDouble(data));
                    break;
                case VANILLA:
                    ((Sweet) current).getIngredients().setVanilla(Double.parseDouble(data));
                    break;
                case COLOR:
                    ((Chocolate) current).setColor(ChocolateColor.valueOf(data.toUpperCase()));
                    break;
                case COCOA_MASS:
                    ((Chocolate) current).getIngredients().setCocoaMass(Double.parseDouble(data));
                    break;
                case COCOA_BUTTER:
                    ((Chocolate) current).getIngredients().setCocoaButter(Double.parseDouble(data));
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name()
                    );
            }
        }
        currentEnum = null;
    }
}
