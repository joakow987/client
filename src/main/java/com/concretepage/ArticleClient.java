package com.concretepage;

import com.concretepage.wsdl.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class ArticleClient extends WebServiceGatewaySupport  {

	public GetProductListResponse getProductList() {
		GetProductListRequest request = new GetProductListRequest();
		GetProductListResponse response = (GetProductListResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/soapws/getProductListRequest"));
		return response;
	}
	public AddToBasketResponse addProduct(Product product) {

		AddToBasketRequest request = new AddToBasketRequest();
		request.setProductId(product.getProductId());
		AddToBasketResponse response = (AddToBasketResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/soapws/addToBasketRequest"));
     	return response;
	}	
	public GetBasketResponse getBasket() {
		GetBasketRequest request = new GetBasketRequest();

		GetBasketResponse response = (GetBasketResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/soapws/getBasketRequest"));
     	return response;
	}	
	public DeleteFromBasketResponse deleteFromBasket(Product product) {
		DeleteFromBasketRequest request = new DeleteFromBasketRequest();
		request.setProductId(product.getProductId());
		DeleteFromBasketResponse response = (DeleteFromBasketResponse) getWebServiceTemplate().marshalSendAndReceive(
				request, new SoapActionCallback("http://localhost:8080/soapws/deleteFromBasketRequest"));
     	return response;
	}	

}
