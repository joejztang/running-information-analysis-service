package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationService {

    List<RunningInformation> saveAll(List<RunningInformation> runningInformations);

    Page<RunningInformation> findByRunningId(String runningId, Pageable pageable);

    Page<RunningInformation> findAllByOrderedHealthWarningLevel(Pageable pageable);

    void deleteByRunningId(String runningId);

    void deleteAll();
}
