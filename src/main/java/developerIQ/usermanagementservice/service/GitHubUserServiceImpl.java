package developerIQ.usermanagementservice.service;


import developerIQ.usermanagementservice.dto.GitHubUserDto;
import developerIQ.usermanagementservice.model.GitHubUser;
import developerIQ.usermanagementservice.repository.GitHubUserRepository;
import developerIQ.usermanagementservice.service.external.GitHubExternalClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GitHubUserServiceImpl implements GitHubUserService {

    private final GitHubExternalClient githubExternalClient;
    private final GitHubUserRepository gitHubUserRepository;

    @Override
    public List<GitHubUser> getGithubUser() {
        List<GitHubUser> githubUsers = new ArrayList<>();

        List<GitHubUserDto> githubUserDtoList = this.githubExternalClient.getUserDetails();
        githubUserDtoList.forEach(githubUserDto -> {
            GitHubUser githubUser = this.generateGitHubUserObject(githubUserDto);
            githubUsers.add(githubUser);
        });

        this.gitHubUserRepository.saveAll(githubUsers);

        return githubUsers;


    }

    @Override
    public List<GitHubUser> getAllUsers() {
        return this.gitHubUserRepository.findAll();
    }

    private GitHubUser generateGitHubUserObject(GitHubUserDto githubUserDto) {
        return GitHubUser.builder()
                .gitHubId(githubUserDto.getId())
                .userName(githubUserDto.getUserName())
                .contributions(githubUserDto.getContributions())
                .type(githubUserDto.getType())
                .siteAdmin(githubUserDto.isSiteAdmin())
                .reposUrl(githubUserDto.getReposUrl())
                .nodeId(githubUserDto.getNodeId())
                .build();
    }

}
