
package com.groupeidyal.dgid.service;


import com.groupeidyal.dgid.dto.ConfirmationRedressementDto;

public interface  ConfirmationRedressementService {

    ConfirmationRedressementDto findConfirmationRedressementByControleuid(String externalid);
}