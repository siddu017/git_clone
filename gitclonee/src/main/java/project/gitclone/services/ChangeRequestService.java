package project.gitclone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.gitclone.entity.ChangeRequestEntity;
import project.gitclone.entity.ChangeStatus;
import project.gitclone.repository.ChangeRequestRepository;

import java.util.List;

@Service
public class ChangeRequestService {
    @Autowired
    private ChangeRequestRepository changeRequestRepository;

    public ChangeRequestEntity submitChange(ChangeRequestEntity changeRequest) {
        changeRequest.setStatus(ChangeStatus.valueOf("PENDING_REVIEW"));
        return changeRequestRepository.save(changeRequest);

    }

    public ChangeRequestEntity approveChange(Long id) {
        ChangeRequestEntity change = changeRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Change not found"));
        change.setStatus(ChangeStatus.valueOf("COMMITTED"));
        return changeRequestRepository.save(change);
    }

    public ChangeRequestEntity rejectChange(Long id, String comment) {
        ChangeRequestEntity change = changeRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Change not found"));
        change.setStatus(ChangeStatus.valueOf("REJECTED"));
        return changeRequestRepository.save(change);
    }

    public List<ChangeRequestEntity> getPendingRequests() {
        return changeRequestRepository.findByStatus("PENDING_REVIEW");
    }

    public List<ChangeRequestEntity> getAllRequests() {
        return changeRequestRepository.findAll();
    }
}
