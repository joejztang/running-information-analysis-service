package demo.rest;

import demo.domain.RunningInformation;
import demo.service.RunningInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInformationRestController {

    private final String defaultPage = "0";
    private final String defaultSize = "2";

    private RunningInformationService runningInformationService;

    @Autowired
    public RunningInformationRestController(RunningInformationService runningInformationService) {
        this.runningInformationService = runningInformationService;
    }

    @RequestMapping(value="/running", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformations) {
        this.runningInformationService.saveAll(runningInformations);
    }

    @RequestMapping(value = "/running/{runningId}", method = RequestMethod.GET)
    public Page<RunningInformation> getByRunningId(
            @PathVariable("runningId") String runningId,
            @RequestParam(name = "page", required = false, defaultValue = defaultPage) int page,
            @RequestParam(name = "size", required = false, defaultValue = defaultSize) int size
    ) {
        return this.runningInformationService.findByRunningId(runningId, PageRequest.of(page, size));
    }

    @RequestMapping(value = "/purge/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable("runningId") String runningId) {
        this.runningInformationService.deleteByRunningId(runningId);
    }

    @RequestMapping(value = "/running/order", method = RequestMethod.GET)
    public Page<RunningInformation> getByOrderedHealthWarningLevel(
            @RequestParam(name = "page", required = false, defaultValue = defaultPage) int page,
            @RequestParam(name = "size", required = false, defaultValue = defaultSize) int size
    ) {
        return this.runningInformationService.findAllByOrderedHealthWarningLevel
                        (PageRequest.of(page, size));
    }

    @RequestMapping(value = "/purgeAll", method = RequestMethod.DELETE)
    public void deleteAll() {
        this.runningInformationService.deleteAll();
    }
}
