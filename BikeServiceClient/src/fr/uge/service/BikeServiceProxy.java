package fr.uge.service;

public class BikeServiceProxy implements fr.uge.service.BikeService {
  private String _endpoint = null;
  private fr.uge.service.BikeService bikeService = null;
  
  public BikeServiceProxy() {
    _initBikeServiceProxy();
  }
  
  public BikeServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBikeServiceProxy();
  }
  
  private void _initBikeServiceProxy() {
    try {
      bikeService = (new fr.uge.service.BikeServiceServiceLocator()).getBikeService();
      if (bikeService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bikeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bikeService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bikeService != null)
      ((javax.xml.rpc.Stub)bikeService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.service.BikeService getBikeService() {
    if (bikeService == null)
      _initBikeServiceProxy();
    return bikeService;
  }
  
  public void removeBikeFromPanier(int idClient, int idBike) throws java.rmi.RemoteException{
    if (bikeService == null)
      _initBikeServiceProxy();
    bikeService.removeBikeFromPanier(idClient, idBike);
  }
  
  public void addBikeToPanier(int idClient, int idBike) throws java.rmi.RemoteException{
    if (bikeService == null)
      _initBikeServiceProxy();
    bikeService.addBikeToPanier(idClient, idBike);
  }
  
  public double getBikePrice(int idBike) throws java.rmi.RemoteException{
    if (bikeService == null)
      _initBikeServiceProxy();
    return bikeService.getBikePrice(idBike);
  }
  
  public java.lang.String buyPanier(int idClient) throws java.rmi.RemoteException{
    if (bikeService == null)
      _initBikeServiceProxy();
    return bikeService.buyPanier(idClient);
  }
  
  public java.lang.String getPanier(int idClient) throws java.rmi.RemoteException{
    if (bikeService == null)
      _initBikeServiceProxy();
    return bikeService.getPanier(idClient);
  }
  
  public boolean isAvailable(int idBike) throws java.rmi.RemoteException{
    if (bikeService == null)
      _initBikeServiceProxy();
    return bikeService.isAvailable(idBike);
  }
  
  
}