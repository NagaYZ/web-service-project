/**
 * FxtopServicesBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package FxtopAPI;

public class FxtopServicesBindingSkeleton implements FxtopAPI.FxtopServicesPortType, org.apache.axis.wsdl.Skeleton {
    private FxtopAPI.FxtopServicesPortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "OriginalAmount"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "C1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "C2"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Date"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "User"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Password"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("convert", _params, new javax.xml.namespace.QName("", "Convert"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:FxtopAPI", "ConvertResult"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "Convert"));
        _oper.setSoapAction("Convert");
        _myOperationsList.add(_oper);
        if (_myOperations.get("convert") == null) {
            _myOperations.put("convert", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("convert")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Lang"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Isocode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("descCurrency", _params, new javax.xml.namespace.QName("", "CurrencyDescription"));
        _oper.setReturnType(new javax.xml.namespace.QName("urn:FxtopAPI", "CurrencyDescription"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "DescCurrency"));
        _oper.setSoapAction("DescCurrency");
        _myOperationsList.add(_oper);
        if (_myOperations.get("descCurrency") == null) {
            _myOperations.put("descCurrency", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("descCurrency")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "User"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "Password"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("listCurrencies", _params, new javax.xml.namespace.QName("", "ListCurrenciesResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "ListCurrencies"));
        _oper.setSoapAction("ListCurrencies");
        _myOperationsList.add(_oper);
        if (_myOperations.get("listCurrencies") == null) {
            _myOperations.put("listCurrencies", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("listCurrencies")).add(_oper);
    }

    public FxtopServicesBindingSkeleton() {
        this.impl = new FxtopAPI.FxtopServicesBindingImpl();
    }

    public FxtopServicesBindingSkeleton(FxtopAPI.FxtopServicesPortType impl) {
        this.impl = impl;
    }
    public FxtopAPI.ConvertResult convert(java.lang.String originalAmount, java.lang.String c1, java.lang.String c2, java.lang.String date, java.lang.String user, java.lang.String password) throws java.rmi.RemoteException
    {
        FxtopAPI.ConvertResult ret = impl.convert(originalAmount, c1, c2, date, user, password);
        return ret;
    }

    public FxtopAPI.CurrencyDescription descCurrency(java.lang.String lang, java.lang.String isocode) throws java.rmi.RemoteException
    {
        FxtopAPI.CurrencyDescription ret = impl.descCurrency(lang, isocode);
        return ret;
    }

    public java.lang.String listCurrencies(java.lang.String user, java.lang.String password) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.listCurrencies(user, password);
        return ret;
    }

}
