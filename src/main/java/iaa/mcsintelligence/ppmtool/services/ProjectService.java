package iaa.mcsintelligence.ppmtool.services;


import iaa.mcsintelligence.ppmtool.domain.Project;
import iaa.mcsintelligence.ppmtool.domain.ProjectRepository;
import iaa.mcsintelligence.ppmtool.exceptions.ProjectIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {

        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);

        }catch (Exception e) {
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' ALREADY EXISTS");
        }

    }
}
