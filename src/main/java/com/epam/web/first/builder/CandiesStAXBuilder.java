package com.epam.web.first.builder;

import com.epam.web.first.entity.Candy;
import com.epam.web.first.entity.Chocolate;
import com.epam.web.first.entity.Sweet;
import com.epam.web.first.exception.CandiesStAXException;
import com.epam.web.first.type.CandyEnum;
import com.epam.web.first.type.ChocolateColor;
import com.epam.web.first.type.SweetType;
import com.epam.web.first.validate.XMLValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CandiesStAXBuilder extends AbstractCandiesBuilder {
    private static final Logger LOG = LogManager.getLogger();

    private XMLInputFactory inputFactory;

    public CandiesStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetCandies(String fileName, String schemaName) {
        if (!checkFileName(fileName) || !checkSchemaName(schemaName)) {
            LOG.log(Level.ERROR, "One of transmittable parameters object is null.");
            return;
        }

        if (!XMLValidator.validate(fileName, schemaName)) {
            return;
        }

        XMLStreamReader reader;
        String name;

        try (FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();

                if (XMLStreamConstants.START_ELEMENT == type) {
                    name = reader.getLocalName();

                    if (CandyEnum.SWEET.getValue().equals(name)) {
                        Sweet sweet = buildSweet(reader);
                        candies.add(sweet);
                    } else if (CandyEnum.CHOCOLATE.getValue().equals(name)) {
                        Chocolate chocolate = buildChocolate(reader);
                        candies.add(chocolate);
                    }
                }
            }
        } catch (XMLStreamException | IOException | CandiesStAXException e) {
            LOG.log(Level.ERROR, e);
        }
    }

    private Chocolate buildChocolate(XMLStreamReader reader) throws XMLStreamException, CandiesStAXException {
        Chocolate chocolate = new Chocolate();
        chocolate.setName(reader.getAttributeValue(null, CandyEnum.NAME.getValue()));

        String name;
        while (reader.hasNext()) {
            int type = reader.next();

            if (XMLStreamConstants.START_ELEMENT == type) {
                name = reader.getLocalName();

                if (CandyEnum.ENERGY.getValue().equals(name)) {
                    chocolate.setEnergy(Double.parseDouble(getXMLText(reader)));
                } else if (CandyEnum.VALUE.getValue().equals(name)) {
                    chocolate.setValue(getXMLValue(reader));
                } else if (CandyEnum.PRODUCTION.getValue().equals(name)) {
                    chocolate.setProduction(getXMLText(reader));
                } else if (CandyEnum.COLOR.getValue().equals(name)) {
                    chocolate.setColor(ChocolateColor.valueOf(getXMLText(reader).toUpperCase()));
                } else if (CandyEnum.INGREDIENTS.getValue().equals(name)) {
                    chocolate.setIngredients(getXMLChocolateIngredients(reader));
                }
            } else if (XMLStreamConstants.END_ELEMENT == type) {
                name = reader.getLocalName();

                if (CandyEnum.CHOCOLATE.getValue().equals(name)) {
                    return chocolate;
                }
            }
        }
        throw new CandiesStAXException("Unknown element in tag Chocolate");
    }

    private Sweet buildSweet(XMLStreamReader reader) throws XMLStreamException, CandiesStAXException {
        Sweet sweet = new Sweet();
        sweet.setName(reader.getAttributeValue(null, CandyEnum.NAME.getValue()));

        String name;
        while (reader.hasNext()) {
            int type = reader.next();

            if (XMLStreamConstants.START_ELEMENT == type) {
                name = reader.getLocalName();

                if (CandyEnum.ENERGY.getValue().equals(name)) {
                    sweet.setEnergy(Double.parseDouble(getXMLText(reader)));
                } else if (CandyEnum.VALUE.getValue().equals(name)) {
                    sweet.setValue(getXMLValue(reader));
                } else if (CandyEnum.PRODUCTION.getValue().equals(name)) {
                    sweet.setProduction(getXMLText(reader));
                } else if (CandyEnum.TYPE.getValue().equals(name)) {
                    sweet.setType(SweetType.valueOf(getXMLText(reader).toUpperCase()));
                } else if (CandyEnum.INGREDIENTS.getValue().equals(name)) {
                    sweet.setIngredients(getXMLSweetIngredients(reader));
                }
            } else if (XMLStreamConstants.END_ELEMENT == type) {
                name = reader.getLocalName();

                if (CandyEnum.SWEET.getValue().equals(name)) {
                    return sweet;
                }
            }
        }
        throw new CandiesStAXException("Unknown element in tag Sweet");
    }

    private Chocolate.ChocolateIngredients getXMLChocolateIngredients(XMLStreamReader reader)
            throws XMLStreamException, CandiesStAXException {
        Chocolate.ChocolateIngredients ingredients = new Chocolate().new ChocolateIngredients();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();

            if (XMLStreamConstants.START_ELEMENT == type) {
                name = reader.getLocalName();

                if (CandyEnum.COCOA_MASS.getValue().equals(name)) {
                    ingredients.setCocoaMass(Double.parseDouble(getXMLText(reader)));
                } else if (CandyEnum.SUGAR.getValue().equals(name)) {
                    ingredients.setSugar(Double.parseDouble(getXMLText(reader)));
                } else if (CandyEnum.COCOA_BUTTER.getValue().equals(name)) {
                    ingredients.setCocoaButter(Double.parseDouble(getXMLText(reader)));
                }
            } else if (XMLStreamConstants.END_ELEMENT == type) {
                name = reader.getLocalName();

                if (CandyEnum.INGREDIENTS.getValue().equals(name)) {
                    return ingredients;
                }
            }
        }
        throw new CandiesStAXException("Unknown element in tag Ingredients");
    }

    private Sweet.SweetIngredients getXMLSweetIngredients(XMLStreamReader reader)
            throws XMLStreamException, CandiesStAXException {
        Sweet.SweetIngredients ingredients = new Sweet().new SweetIngredients();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();

            if (XMLStreamConstants.START_ELEMENT == type) {
                name = reader.getLocalName();

                if (CandyEnum.WATER.getValue().equals(name)) {
                    ingredients.setWater(Double.parseDouble(getXMLText(reader)));
                } else if (CandyEnum.SUGAR.getValue().equals(name)) {
                    ingredients.setSugar(Double.parseDouble(getXMLText(reader)));
                } else if (CandyEnum.FRUCTOSE.getValue().equals(name)) {
                    ingredients.setFructose(Double.parseDouble(getXMLText(reader)));
                } else if (CandyEnum.VANILLA.getValue().equals(name)) {
                    ingredients.setVanilla(Double.parseDouble(getXMLText(reader)));
                }
            } else if (XMLStreamConstants.END_ELEMENT == type) {
                name = reader.getLocalName();

                if (CandyEnum.INGREDIENTS.getValue().equals(name)) {
                    return ingredients;
                }
            }
        }
        throw new CandiesStAXException("Unlnown element in tag Ingredients");
    }

    private Candy.Value getXMLValue(XMLStreamReader reader) throws XMLStreamException, CandiesStAXException {
        Candy.Value value = new Candy.Value();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();

            if (XMLStreamConstants.START_ELEMENT == type) {
                name = reader.getLocalName();

                if (CandyEnum.PROTEINS.getValue().equals(name)) {
                    value.setProteins(Double.parseDouble(getXMLText(reader)));
                } else if (CandyEnum.FATS.getValue().equals(name)) {
                    value.setFats(Double.parseDouble(getXMLText(reader)));
                } else if (CandyEnum.CARBOHYDRATES.getValue().equals(name)) {
                    value.setCarbohydrates(Double.parseDouble(getXMLText(reader)));
                }
            } else if (XMLStreamConstants.END_ELEMENT == type) {
                name = reader.getLocalName();

                if (CandyEnum.VALUE.equals(CandyEnum.valueOf(name.toUpperCase()))) {
                    return value;
                }
            }
        }
        throw new CandiesStAXException("Unknown element in tag Value");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
