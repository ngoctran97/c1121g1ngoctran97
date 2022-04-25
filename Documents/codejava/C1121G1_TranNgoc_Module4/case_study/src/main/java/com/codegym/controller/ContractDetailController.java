package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contractService.IAttachServiceService;
import com.codegym.service.contractService.IContractDetailService;
import com.codegym.service.contractService.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract_detail")
public class ContractDetailController {

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IContractService contractService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @GetMapping(value = {"", "/list"})
    public String index(Model model,
                        @PageableDefault(value = 5) Pageable pageable,
                        @RequestParam("name") Optional<String> keyword) {
        String keywordValue = keyword.orElse("");
        Page<ContractDetail> contractDetailPage = contractDetailService.findAll(keywordValue, pageable);
        model.addAttribute("contractDetailPage", contractDetailPage);
        model.addAttribute("keywordValue", keywordValue);

        return "contract_detail/index";
    }

    @GetMapping(value = {"/customer_use_service_list","/lists"})
    public String customerUserList(Model model,
                                   @PageableDefault(value = 5) Pageable pageable,
                                   @RequestParam("name") Optional<String> keyword){
        String keywordValue = keyword.orElse("");
        Page<ContractDetail> contractDetailPage = contractDetailService.findAll(keywordValue,pageable);
        model.addAttribute("contractDetailPage", contractDetailPage);
        model.addAttribute("keywordValue", keywordValue);

        return "contract_detail/customer_use_list";
    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("contract_detail/create");
        modelAndView.addObject("contractDetailDto", new ContractDetailDto());
        modelAndView.addObject("contract",contractService.findAll());
        modelAndView.addObject("attachService",attachServiceService.findAll());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String createForm(@Valid @ModelAttribute ContractDetailDto contractDetailDto,
                             BindingResult bindingResult,
                             Model model) {

        contractDetailDto.validate(contractDetailDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            List<Contract> contractList = contractService.findAll();
            model.addAttribute("contractList",contractList);
            List<AttachService> attachServiceList = attachServiceService.findAll();
            model.addAttribute("attachServiceList",attachServiceList);
            model.addAttribute("contractDetailDto", contractDetailDto);
            return "contract_detail/create";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
//        contractDetail.getContract().setContractTotalMoney();
        contractDetailService.save(contractDetail);
        return "redirect:/contract_detail/list";
    }



}
