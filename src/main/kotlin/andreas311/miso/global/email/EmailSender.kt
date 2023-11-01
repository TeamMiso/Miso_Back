package andreas311.miso.global.email

import andreas311.miso.domain.email.entity.Email
import andreas311.miso.domain.email.exception.EmailSendFailedException
import andreas311.miso.domain.email.repository.EmailRepository
import andreas311.miso.global.util.EmailUtil
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import javax.mail.MessagingException

@Component
class EmailSender(
    private val emailUtil: EmailUtil,
    private val javaMailSender: JavaMailSender,
    private val emailRepository: EmailRepository
) {

    fun execute(email: String) {
        val randomKey = emailUtil.createRandomKey()
        sendAuthEmail(email, randomKey)
    }

    private fun sendAuthEmail(email: String, randomKey: String) {
        val subject = "Miso 인증 번호가 도착했습니다!"
        val content = buildEmailContent(randomKey)

        try {
            sendEmail(email, subject, content)
        } catch (e: MessagingException) {
            throw EmailSendFailedException()
        }
        saveEmailToRepository(email, randomKey)
    }

    private fun buildEmailContent(randomKey: String): String {
        return """
            <div style='margin:100px;'>
            <h1> 안녕하세요 Team Miso 입니다! </h1>
            <br>
            <h2><p>아래 인증 번호를 인증 페이지로 돌아가 입력해주세요. 이용해 주셔서 감사합니다!<p></h2>
            <br>
            <div align='center' style='border:1px solid black; font-family:verdana';>
            <h3 style='color:blue;'>인증 번호는 다음과 같습니다!</h3>
            <div style='font-size:130%'>
            인증 번호 : <strong>$randomKey</strong><div><br/> 
            </div>
        """.trimIndent()
    }

    private fun saveEmailToRepository(email: String, randomKey: String) {
        emailRepository.save(Email(0L, email, randomKey, false))
    }

    private fun sendEmail(email: String, subject: String, content: String) {
        val mimeMessage = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(mimeMessage, true, "utf-8")
        helper.setTo(email)
        helper.setSubject(subject)
        helper.setText(content, true)
        javaMailSender.send(mimeMessage)
    }
}
