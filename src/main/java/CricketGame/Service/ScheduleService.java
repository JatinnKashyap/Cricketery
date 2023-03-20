package CricketGame.Service;

import CricketGame.Entity.SQLEntity.ScheduleEntity;
import CricketGame.Repository.ESRepository.ESScheduleRepository;
import CricketGame.Repository.SQLRepository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ESScheduleRepository esScheduleRepository;

    public ScheduleEntity getSchedule(Long scheduleId){
        return scheduleRepository.findById(scheduleId).orElse(null);
    }

    public void reset(){

        scheduleRepository.deleteAll();
        esScheduleRepository.deleteAll();

    }
}
