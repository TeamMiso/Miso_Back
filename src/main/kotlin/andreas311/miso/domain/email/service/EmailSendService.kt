package andreas311.miso.domain.email.service

interface EmailSendService {

    fun execute(email: String)
}