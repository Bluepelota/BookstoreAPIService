package profilemanagement.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Geektext.repository.CreditCardRepository;



@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    public CreditCardRepository getCreditCardRepository() {
        return creditCardRepository;
    }

    public void setCreditCardRepository(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

}
