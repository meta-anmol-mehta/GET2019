/**
 * TriangleAreaServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube.training.soap;

public class TriangleAreaServiceLocator extends org.apache.axis.client.Service implements com.metacube.training.soap.TriangleAreaService {

    public TriangleAreaServiceLocator() {
    }


    public TriangleAreaServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TriangleAreaServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TriangleArea
    private java.lang.String TriangleArea_address = "http://localhost:8080/EAD-Assignment-SOAP/services/TriangleArea";

    public java.lang.String getTriangleAreaAddress() {
        return TriangleArea_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TriangleAreaWSDDServiceName = "TriangleArea";

    public java.lang.String getTriangleAreaWSDDServiceName() {
        return TriangleAreaWSDDServiceName;
    }

    public void setTriangleAreaWSDDServiceName(java.lang.String name) {
        TriangleAreaWSDDServiceName = name;
    }

    public com.metacube.training.soap.TriangleArea getTriangleArea() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TriangleArea_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTriangleArea(endpoint);
    }

    public com.metacube.training.soap.TriangleArea getTriangleArea(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.metacube.training.soap.TriangleAreaSoapBindingStub _stub = new com.metacube.training.soap.TriangleAreaSoapBindingStub(portAddress, this);
            _stub.setPortName(getTriangleAreaWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTriangleAreaEndpointAddress(java.lang.String address) {
        TriangleArea_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.metacube.training.soap.TriangleArea.class.isAssignableFrom(serviceEndpointInterface)) {
                com.metacube.training.soap.TriangleAreaSoapBindingStub _stub = new com.metacube.training.soap.TriangleAreaSoapBindingStub(new java.net.URL(TriangleArea_address), this);
                _stub.setPortName(getTriangleAreaWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TriangleArea".equals(inputPortName)) {
            return getTriangleArea();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.training.metacube.com", "TriangleAreaService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.training.metacube.com", "TriangleArea"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TriangleArea".equals(portName)) {
            setTriangleAreaEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
