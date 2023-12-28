package developerIQ.usermanagementservice;

import developerIQ.usermanagementservice.dto.GitHubUserDto;
import developerIQ.usermanagementservice.model.GitHubUser;
import developerIQ.usermanagementservice.repository.GitHubUserRepository;
import developerIQ.usermanagementservice.service.GitHubUserServiceImpl;
import developerIQ.usermanagementservice.service.external.GitHubExternalClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GitHubUserServiceImplIntegrationTest {

    @Test
    public void testGetGithubUser() {
        // Mock the GitHubExternalClient and GitHubUserRepository
        GitHubExternalClient gitHubExternalClient = Mockito.mock(GitHubExternalClient.class);
        GitHubUserRepository gitHubUserRepository = Mockito.mock(GitHubUserRepository.class);

        // Create an instance of GitHubUserServiceImpl with the mock dependencies
        GitHubUserServiceImpl gitHubUserService = new GitHubUserServiceImpl(gitHubExternalClient, gitHubUserRepository);

        // Mock data for the GitHubExternalClient response
        List<GitHubUserDto> mockGitHubUserDtoList = Arrays.asList(
                new GitHubUserDto("user1", 1, "nodeId1", "avatarUrl1", "gravatarId1", "url1", "htmlUrl1", "followersUrl1",
                        "followingUrl1", "gistsUrl1", "starredUrl1", "subscriptionsUrl1", "organizationsUrl1",
                        "reposUrl1", "eventsUrl1", "receivedEventsUrl1", "type1", false, 10),
                new GitHubUserDto("user2", 2, "nodeId2", "avatarUrl2", "gravatarId2", "url2", "htmlUrl2", "followersUrl2",
                        "followingUrl2", "gistsUrl2", "starredUrl2", "subscriptionsUrl2", "organizationsUrl2",
                        "reposUrl2", "eventsUrl2", "receivedEventsUrl2", "type2", true, 15)
                // Add more mock data as needed
        );

        // Mock the behavior of the GitHubExternalClient when getUserDetails is called
        when(gitHubExternalClient.getUserDetails()).thenReturn(mockGitHubUserDtoList);

        // Mock the behavior of the GitHubUserRepository when saveAll is called
        when(gitHubUserRepository.saveAll(Mockito.anyList()))
                .thenAnswer(invocation -> {
                    List<GitHubUser> savedUsers = invocation.getArgument(0);  // Capture the argument
                    // You may need to convert savedUsers to GitHubUserDto before saving
                    return savedUsers;
                });

        // Call the method to be tested
        List<GitHubUser> result = gitHubUserService.getGithubUser();

        // Perform assertions based on your expected behavior
        assertEquals(mockGitHubUserDtoList.size(), result.size());

    }


}
