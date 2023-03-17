package CricketGame.Service;

import CricketGame.Entity.ScheduleEntity;
import CricketGame.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleEntity getSchedule(Long scheduleId){
        return scheduleRepository.findById(scheduleId).orElse(null);
    }
}
