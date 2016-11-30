package com.epam.web.first.command;

import com.epam.web.first.entity.Candy;
import com.epam.web.first.entity.Chocolate;
import com.epam.web.first.entity.Sweet;
import com.epam.web.first.logic.ParseLogic;
import com.epam.web.first.manager.ConfigurationManager;
import com.epam.web.first.upload.FileUploader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

public class ParseCommand implements ActionCommand {
    private static final String PARAM_TYPE_PARSER = "typeParser";
    private static final String PARAM_LOCALE = "locale";
    private static final String PARAM_LANGUAGE = "language";
    private static final String PARAM_SWEETS = "sweets";
    private static final String PARAM_CHOCOLATES = "chocolates";
    private static final String PATH_PAGE_RESULT = "path.page.result";

    private static final Logger LOG = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        FileUploader uploader = new FileUploader(request);
        String typeParser = uploader.getParameterValue(PARAM_TYPE_PARSER);

        Set<Candy> candies = ParseLogic.parse(request, typeParser, uploader);
        Set<Sweet> sweets = new HashSet<>();
        Set<Chocolate> chocolates = new HashSet<>();
        ConfigurationManager manager = new ConfigurationManager();

        for (Candy temp : candies) {
            if (temp instanceof Sweet) {
                sweets.add((Sweet) temp);
            } else if (temp instanceof Chocolate) {
                chocolates.add((Chocolate) temp);
            }
        }

        HttpSession session = request.getSession(true);
        String currLocale = (String) session.getAttribute(PARAM_LANGUAGE);
        request.setAttribute(PARAM_SWEETS, sweets);
        request.setAttribute(PARAM_CHOCOLATES, chocolates);
        request.setAttribute(PARAM_LOCALE, currLocale);
        request.setAttribute(PARAM_TYPE_PARSER, typeParser);

        return manager.getProperty(PATH_PAGE_RESULT);
    }
}
