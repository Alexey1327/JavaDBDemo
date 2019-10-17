package ru.lanit.demodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.lanit.demodb.services.PeopleService;
import ru.lanit.demodb.dto.PeopleDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/people_info")
@Transactional
public class PeopleInfoController {

    private final static String JSP_PAGE = "people_info";

    private PeopleService peopleService;

    @Autowired
    public PeopleInfoController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getPeopleInfoAction() {
        Map<String, List<PeopleDto>> map = new HashMap<>();
        List<PeopleDto> peopleListDto = peopleService.getPeoplesData();
        map.put("peopleListDto", peopleListDto);
        return new ModelAndView(JSP_PAGE, map);
    }
}
