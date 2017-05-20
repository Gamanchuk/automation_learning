package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXPars extends DefaultHandler {
    private Log log = LogFactory.getLog(SAXPars.class.getSimpleName());

    @Override
    public void startDocument() throws SAXException {
        log.info("Start parse XML...");
    }
}
