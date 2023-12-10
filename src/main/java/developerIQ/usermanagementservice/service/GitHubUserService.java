package developerIQ.usermanagementservice.service;


import developerIQ.usermanagementservice.model.GitHubUser;

import java.util.List;

public interface GitHubUserService {
    List<GitHubUser> getGithubUser();

    List<GitHubUser> getAllUsers();
}