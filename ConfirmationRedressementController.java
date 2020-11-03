package com.groupeidyal.dgid.controller.backend;

import com.groupeidyal.dgid.dto.ConfirmationRedressementDto;

import com.groupeidyal.dgid.service.*;
import com.madtech.apitools.annotation.APIController;
import com.madtech.apitools.annotation.Operation;
import com.madtech.apitools.annotation.Operations;
import com.madtech.apitools.annotation.Parameter;
import com.madtech.apitools.helper.ParamList;
import com.madtech.apitools.model.Response;
import org.springframework.beans.factory.annotation.Autowired;

import static com.madtech.apitools.helper.DataTypeChecker.SupportedTypes.TEXT;

@APIController("confirmationredressement")
@Operations({
        @Operation(value = "confirmationredressementbyControle", params = {
        @Parameter(value = "uidControle", type = TEXT)
})

})
public class ConfirmationRedressementController {


    private final ConfirmationRedressementService confirmationRedressementService;

    @Autowired
    public ConfirmationRedressementController(ConfirmationRedressementService confirmationRedressementService) {
        this.confirmationRedressementService = confirmationRedressementService;
    }

    /**
     *
     * @param paramList
     * @return
     */
    public Response confirmationredressementbyControle(ParamList paramList) {
        String uidControle = (String) paramList.getParamValue("uidControle");
        ConfirmationRedressementDto confirmationRedressementDto =
                confirmationRedressementService.findConfirmationRedressementByControleuid(uidControle);
        System.out.println("===============================================================");
        System.out.print(confirmationRedressementDto);
        System.out.println("===============================================================");
        return Response.write(confirmationRedressementDto);
    }
}
