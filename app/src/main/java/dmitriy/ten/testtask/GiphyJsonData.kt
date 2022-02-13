package dmitriy.ten.testtask

data class GiphyJsonData(val data: Data) {
    inner class Data(val images: Images) {
        inner class Images(val original: Original) {
            inner class Original(val url: String)
        }
    }
}