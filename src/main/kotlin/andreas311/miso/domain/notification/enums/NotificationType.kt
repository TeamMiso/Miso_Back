package andreas311.miso.domain.notification.enums

enum class NotificationType(
    val title: String,
    val content: String
) {

    INQUIRT_WAIT(
        title = "MISO 문의사항 등록 완료!",
        content = "최대한 빠르게 답변 드릴테니 기다려주세요 :)"
    ),

    INQUIRY_COMPLETE(
        title = "MISO 문의사항 답변 도착!",
        content = "내 문의 내역에서 답변을 확인해주세요 :)"
    )
}