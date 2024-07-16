package com.xxahrutoxx.countAndMovement.services.movement;

import com.xxahrutoxx.countAndMovement.dto.AccountReportDTO;
import com.xxahrutoxx.countAndMovement.dto.ClientReportDTO;
import com.xxahrutoxx.countAndMovement.entities.Movement;

import java.util.Date;
import java.util.List;

public interface IMovementService {
    List<Movement> findAll();
    Movement findById(Long id);
    Movement save(Movement movement);

    List<ClientReportDTO> getAccountsReport(Date startDate, Date endDate);

}
