package demo.service.impl;

import demo.domain.RunningInformation;
import demo.domain.RunningInformationRepository;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunningInformationServiceImpl implements RunningInformationService {

    RunningInformationRepository runningInformationRepository;

    @Autowired
    public RunningInformationServiceImpl(RunningInformationRepository runningInformationRepository) {
        this.runningInformationRepository = runningInformationRepository;
    }

    @Override
    public List<RunningInformation> saveAll(List<RunningInformation> runningInformations) {
        return this.runningInformationRepository.saveAll(runningInformations);
    }

    @Override
    public Page<RunningInformation> findByRunningId(String runningId, Pageable pageable) {
        return this.runningInformationRepository.findByRunningId(runningId, pageable);
    }

    @Override
    public Page<RunningInformation> findAllByOrderedHealthWarningLevel(Pageable pageable) {
        return this.runningInformationRepository.findAllRunningInformationByOrderByWarningLevel(pageable);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        this.runningInformationRepository.deleteByRunningId(runningId);
    }

    @Override
    public void deleteAll() {
        this.runningInformationRepository.deleteAll();
    }
}
