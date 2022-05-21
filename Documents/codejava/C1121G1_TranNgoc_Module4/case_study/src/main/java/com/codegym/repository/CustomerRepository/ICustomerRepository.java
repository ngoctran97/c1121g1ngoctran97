package com.codegym.repository.CustomerRepository;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.ICustomerUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByCustomerNameContainingAndDeleteFlag(String customerName, boolean deleteFlag, Pageable pageable);

    Customer findByCustomerCode(String code);

    @Query(value = "select customer.customer_code as customerCode,customer.customer_name as customerName,contract.contract_id as contractId,contract_detail.contract_detail_id as contractDetailId, " +
            "attach_service.attach_service_id as attachServiceId,attach_service.attach_service_name as attachServiceName " +
            "from customer " +
            "join contract on customer.customer_id = contract.customer_id " +
            "join contract_detail on contract.contract_id = contract_detail.contract_id " +
            "join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id ",
            countQuery = "select count(*) from customer "+
                    "join contract on customer.customer_id = contract.customer_id " +
                    "join contract_detail on contract.contract_id = contract_detail.contract_id " +
                    "join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id ",
            nativeQuery = true)
    <T> Page<T> findAllCustomerUserPage(Class<T> classType, Pageable pageable);
}
