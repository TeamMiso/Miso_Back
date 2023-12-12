package andreas311.miso.domain.notification.enums

enum class NotificationType(
    val title: String,
    val content: String
) {

    INQUIRT_WAIT(
        title = "MISO 문의사항 등록 완료!",
        content = "최대한 빠르게 답변 드릴테니 기다려주세요 :)"
    ),

    INQUIRY_ADOPT(
        title = "MISO 문의사항 채택 완료!",
        content = "자세한 사항은 앱에서 확인해주세요 :)"
    ),

    INQUIRY_UNADOPT(
        title = "MISO 문의사항 비채택..",
        content = "자세한 사항은 앱에서 확인해주세요 :("
    ),
}