package developerIQ.usermanagementservice.controller;

import developerIQ.usermanagementservice.model.GitHubUser;
import developerIQ.usermanagementservice.service.GitHubUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/git-hub")

public class UserController {
    private GitHubUserService gitHubUserService;

    @GetMapping("/contributors")
    public ResponseEntity<List<GitHubUser>> getGithubUser() {
        return ResponseEntity.ok(this.gitHubUserService.getGithubUser());
    }

    @GetMapping("/contributors/get-all")
    public ResponseEntity<List<GitHubUser>> getAllUsers() {
        return ResponseEntity.ok(this.gitHubUserService.getAllUsers());
    }
}