package de.dh.lhind.demo.jobapi.rest.controller;

import de.dh.lhind.demo.jobapi.rest.controller.common.CommonCrudRestController;
import de.dh.lhind.demo.jobcore.business.dto.JobDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController extends CommonCrudRestController<JobDTO, Long> {
}
