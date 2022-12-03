package fr.uge.bankservice;

public class BankServiceProxy implements fr.uge.bankservice.BankService {
  private String _endpoint = null;
  private fr.uge.bankservice.BankService bankService = null;
  
  public BankServiceProxy() {
    _initBankServiceProxy();
  }
  
  public BankServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initBankServiceProxy();
  }
  
  private void _initBankServiceProxy() {
    try {
      bankService = (new fr.uge.bankservice.BankServiceServiceLocator()).getBankService();
      if (bankService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bankService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bankService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bankService != null)
      ((javax.xml.rpc.Stub)bankService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public fr.uge.bankservice.BankService getBankService() {
    if (bankService == null)
      _initBankServiceProxy();
    return bankService;
  }
  
  public void openAccount(int idClient, double amount, java.lang.String currency) throws java.rmi.RemoteException{
    if (bankService == null)
      _initBankServiceProxy();
    bankService.openAccount(idClient, amount, currency);
  }
  
  public boolean debit(int idClient, double amount) throws java.rmi.RemoteException{
    if (bankService == null)
      _initBankServiceProxy();
    return bankService.debit(idClient, amount);
  }
  
  public void credit(int idClient, double amount) throws java.rmi.RemoteException{
    if (bankService == null)
      _initBankServiceProxy();
    bankService.credit(idClient, amount);
  }
  
  
}