package pl.marchuck.customer;


public interface CustomerRepository {
    CustomerProtos.Customer findById(int id);
}


