package com.lenir.translate_service.communicator;

public interface PortalTranslateParameter extends PortalParameter{
    public String getQuery();
    public String getTargetLang();
    public String getSourceLang();
}
