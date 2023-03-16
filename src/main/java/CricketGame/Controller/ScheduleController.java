package CricketGame.Controller;

import CricketGame.Entity.PlayerEntity;
import CricketGame.Entity.ScheduleEntity;
import CricketGame.Service.PlayerService;
import CricketGame.Service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/{id}")
    public ScheduleEntity get(@PathVariable Long id){
        return scheduleService.getSchedule(id);
    }
}
