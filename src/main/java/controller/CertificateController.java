package controller;

import model.Certificate;
import model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repo.CertificateRepository;
import repo.UserRepository;
import repo.UserTokenRepository;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private UserRepository userRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private UserTokenRepository userTokenRepository;

    @org.springframework.beans.factory.annotation.Autowired(required=true)
    private CertificateRepository certificateRepository;

    @PostMapping("/add")
    public void createCertificate(String token, Long userId, String name, String description)
    {
        if (userTokenRepository.existsByUserIdAndToken(userId,token))
        {
            User user = userTokenRepository.getByIdAndToken(userId,token);
            if (user.getUserType() == User.UserType.ADMIN)
            {
                Certificate certificate = new Certificate(name, 100);
                certificateRepository.save(certificate);
            }
        }


    }

}
