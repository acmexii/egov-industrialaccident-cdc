package industrialaccident.infra;

import industrialaccident.domain.*;
import industrialaccident.service.*;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
// @RequestMapping(value="/accidents")
public class AccidentController {

    @Value("${api.url.assessment}")
    private String apiUrl;

    @Resource(name = "accidentService")
    private AccidentService accidentService;

    @GetMapping("/accidents")
    public List<Accident> getAllAccidents() throws Exception {
        // Get all accidents via AccidentService
        return accidentService.getAllAccidents();
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/validateAssessment/{id}")
    public ResponseEntity<String> assessmentCheck(@PathVariable(value = "id") Long id) {
    
        String assessmentUrl = apiUrl + "/assessments/" + id;
    
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
    
        ResponseEntity<String> assessmentEntity = restTemplate.exchange(assessmentUrl, HttpMethod.GET, entity, String.class);
    
        return assessmentEntity;
    }

    @GetMapping("/accidents/{id}")
    public Optional<Accident> getAccidentById(@PathVariable Long id)
        throws Exception {
        // Get a accident by ID via AccidentService
        return accidentService.getAccidentById(id);
    }

    @PostMapping("/accidents")
    public Accident createAccident(@RequestBody Accident accident)
        throws Exception {
        // Create a new accident via AccidentService
        return accidentService.createAccident(accident);
    }

    @PutMapping("/accidents/{id}")
    public Accident updateAccident(
        @PathVariable Long id,
        @RequestBody Accident accident
    ) throws Exception {
        // Update an existing accident via AccidentService
        return accidentService.updateAccident(accident);
    }

    @DeleteMapping("/accidents/{id}")
    public void deleteAccident(@PathVariable Long id) throws Exception {
        // Delete a accident via AccidentService
        accidentService.deleteAccident(id);
    }

    @RequestMapping(
        value = "accidents",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Accident applyMedicalBenefit(
        @RequestBody ApplyMedicalBenefitCommand applyMedicalBenefitCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        return accidentService.applyMedicalBenefit(applyMedicalBenefitCommand);
    }

    @RequestMapping(
        value = "/accidents/{id}/applysickleavepay",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Accident applySickLeaveBenefit(
        @PathVariable(value = "id") Long id,
        @RequestBody ApplySickLeaveBenefitCommand applySickLeaveBenefitCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        return accidentService.applySickLeaveBenefit(
            applySickLeaveBenefitCommand
        );
    }
}
