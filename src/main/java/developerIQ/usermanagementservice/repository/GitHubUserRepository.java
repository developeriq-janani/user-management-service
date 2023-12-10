package developerIQ.usermanagementservice.repository;

import developerIQ.usermanagementservice.model.GitHubUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitHubUserRepository extends MongoRepository<GitHubUser, String> {

}