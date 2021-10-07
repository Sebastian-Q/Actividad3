package mx.edu.utez.Productos.controller;


import mx.edu.utez.Productos.model.Customer.Customer;
import mx.edu.utez.Productos.model.Customer.DaoCustomer;

import mx.edu.utez.Productos.model.ProductLine.ProductLine;
import mx.edu.utez.Productos.model.ProductLine.DaoProductLine;

import mx.edu.utez.Productos.model.Products.Products;
import mx.edu.utez.Productos.model.Products.DaoProducts;

import mx.edu.utez.Productos.model.Office.Office;
import mx.edu.utez.Productos.model.Office.DaoOffice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;



@Path("/customer")
public class Service {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getEmployees() {
        return new DaoCustomer().findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") int customerNumber) {
        return new DaoCustomer().findByCustomerNumber(customerNumber);
    }

    @POST//actualizar
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Customer save(MultivaluedMap<String, String> formParams) {
        int customerNumber = Integer.parseInt(formParams.get("customerNumber").get(0));

        if (new DaoCustomer().saveCustomer(getParams(customerNumber, formParams), true)){
            return new DaoCustomer().findByCustomerNumber(customerNumber);
        }else{
            return null;
        }
    }

    @POST//registrar
    @Path("/save/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Customer save(@PathParam("id") int customerNumber, MultivaluedMap<String, String> formParams) {
        if (new DaoCustomer().saveCustomer(getParams(customerNumber, formParams), false)){
            return new DaoCustomer().findByCustomerNumber(customerNumber);
        }else{
            return null;
        }
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteCustomer(@PathParam("id") int customerNumber) {
        return new DaoCustomer().deleteCustomer(customerNumber);
    }

    private Customer getParams(int customerNumber, MultivaluedMap<String, String> formParams) {
        String customerName = formParams.get("customerName").get(0);
        String contactLastName = formParams.get("contactLastName").get(0);
        String contactFirstName = formParams.get("contactFirstName").get(0);
        String phone = formParams.get("phone").get(0);
        String addressLine1 = formParams.get("addressLine1").get(0);
        String addressLine2 = formParams.get("addressLine2").get(0);
        String city = formParams.get("city").get(0);
        String state = formParams.get("state").get(0);
        String postalCode = formParams.get("postalCode").get(0);
        String country = formParams.get("country").get(0);
        int salesRepEmployeeNumber = Integer.parseInt(formParams.get("salesRepEmployeeNumber").get(0));
        double creditLimit = Double.parseDouble(formParams.get("creditLimit").get(0));
        Customer customer = new Customer(customerNumber, customerName,contactLastName, contactFirstName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit);
        System.out.println(customer);
        return customer;
    }




    //Offices
    @GET
    @Path("/offices/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Office> getOffices() {
        return new DaoOffice().findAll();
    }

    @GET
    @Path("/offices/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Office getOffice(@PathParam("id") String officeCode) {
        return new DaoOffice().findByOffice(officeCode);
    }

    @POST//actualizar
    @Path("/offices/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Office saveOffice(MultivaluedMap<String, String> formParams) {
        String officeCode = formParams.get("officeCode").get(0);

        if (new DaoOffice().saveOffices(getParamsOffices(officeCode, formParams), true)){
            return new DaoOffice().findByOffice(officeCode);
        }else{
            return null;
        }
    }

    @POST//registrar
    @Path("/offices/save/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Office saveOffice(@PathParam("id") String officeCode, MultivaluedMap<String, String> formParams) {
        if (new DaoOffice().saveOffices(getParamsOffices(officeCode, formParams), false)){
            return new DaoOffice().findByOffice(officeCode);
        }else{
            return null;
        }
    }

    @DELETE
    @Path("/offices/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteOffice(@PathParam("id") String officeCode) {
        return new DaoOffice().deleteOffice(officeCode);
    }

    private Office getParamsOffices(String officeCode, MultivaluedMap<String, String> formParams) {
        String city = formParams.get("city").get(0);
        String phone = formParams.get("phone").get(0);
        String addressLine1 = formParams.get("addressLine1").get(0);
        String addressLine2 = formParams.get("addressLine2").get(0);
        String state = formParams.get("state").get(0);
        String country = formParams.get("country").get(0);
        String postalCode = formParams.get("postalCode").get(0);
        String territory = formParams.get("territory").get(0);
        Office office = new Office(officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory);
        System.out.println(office);
        return office;
    }
    //Product lines
    @GET
    @Path("/productlines/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductLine> getProductLines() {
        return new DaoProductLine().findAll();
    }

    @GET
    @Path("/productlines/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductLine getProductLine(@PathParam("id") String productLine) {
        return new DaoProductLine().findByProductlinesCode(productLine);
    }

    @POST//actualizar
    @Path("/productlines/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public ProductLine saveProductLine(MultivaluedMap<String, String> formParams) {
        String productLine = formParams.get("productLine").get(0);

        if (new DaoProductLine().saveProductlines(getParamsProdLines(productLine, formParams), true)){
            return new DaoProductLine().findByProductlinesCode(productLine);
        }else{
            return null;
        }
    }

    @POST//registrar
    @Path("/productlines/save/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public ProductLine saveProductLine(@PathParam("id") String productLine, MultivaluedMap<String, String> formParams) {
        if (new DaoProductLine().saveProductlines(getParamsProdLines(productLine, formParams), false)){
            return new DaoProductLine().findByProductlinesCode(productLine);
        }else{
            return null;
        }
    }

    @DELETE
    @Path("/productlines/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteProdLines(@PathParam("id") String productLine) {
        return new DaoProductLine().deleteProductlines(productLine);
    }

    private ProductLine getParamsProdLines(String productLine, MultivaluedMap<String, String> formParams) {
        String textDescription = formParams.get("textDescription").get(0);
        String htmlDescription = formParams.get("htmlDescription").get(0);
        String image = formParams.get("image").get(0);
        ProductLine ProductLine  = new ProductLine(productLine, textDescription, htmlDescription, image);
        System.out.println(ProductLine);
        return ProductLine;
    }
    //Products
    @GET
    @Path("/products/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Products> getProducts() {
        return new DaoProducts().findAll();
    }

    @GET
    @Path("/products/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Products getProduct(@PathParam("id") String productCode) {
        return new DaoProducts().findByProductCode(productCode);
    }

    @POST//actualizar
    @Path("/products/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Products saveProduct(MultivaluedMap<String, String> formParams) {
        String productCode = formParams.get("productCode").get(0);

        if (new DaoProducts().saveProducts(getParamsProduct(productCode, formParams), true)){
            return new DaoProducts().findByProductCode(productCode);
        }else{
            return null;
        }
    }

    @POST//registrar
    @Path("/products/save/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/x-www-form-urlencoded")
    public Products saveProduct(@PathParam("id") String productCode, MultivaluedMap<String, String> formParams) {
        if (new DaoProducts().saveProducts(getParamsProduct(productCode, formParams), false)){
            return new DaoProducts().findByProductCode(productCode);
        }else{
            return null;
        }
    }

    @DELETE
    @Path("/products/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteProduct(@PathParam("id") String productCode) {
        return new DaoProducts().deleteProducts(productCode);
    }

    private Products getParamsProduct(String productCode, MultivaluedMap<String, String> formParams) {
        String productName = formParams.get("productName").get(0);
        String productLine = formParams.get("productLine").get(0);
        String productScale = formParams.get("productScale").get(0);
        String productVendor = formParams.get("productVendor").get(0);
        String productDescription = formParams.get("productDescription").get(0);
        int quantityInStock = Integer.parseInt(formParams.get("quantityInStock").get(0));
        double buyPrice = Double.parseDouble(formParams.get("buyPrice").get(0));
        double MSRP = Double.parseDouble(formParams.get("MSRP").get(0));

        Products product  = new Products(productCode, productName, productLine, productScale, productVendor, productDescription , quantityInStock, buyPrice, MSRP);
        System.out.println(product);
        return product;
    }
}