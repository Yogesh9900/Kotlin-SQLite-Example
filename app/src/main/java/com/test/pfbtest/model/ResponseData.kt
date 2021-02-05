package com.test.pfbtest.model


/**
 * Created by Yogesh Y. Nikam on 03/02/21.
 */

class ResponseData {

    var response: Response = Response()
        get() = field
        set(value) {
            field = value
        }
}


class Response {

    var numFound: Int = -1
        get() = field
        set(value) {
            field = value
        }

    var start: Int = -1
        get() = field
        set(value) {
            field = value
        }

    var maxScore: Double = 0.0
        get() = field
        set(value) {
            field = value
        }

    var docs: List<Docs> = listOf<Docs>()
        get() = field
        set(value) {
            field = value
        }
}


class Docs {


    var id: String = ""
        get() = field
        set(value) {
            field = value
        }


    var eissn: String = ""
        get() = field
        set(value) {
            field = value
        }


    var publication_date: String = ""
        get() = field
        set(value) {
            field = value
        }


    var article_type: String = ""
        get() = field
        set(value) {
            field = value
        }


    var title_display: String = ""
        get() = field
        set(value) {
            field = value
        }


    var score: Double = 0.0
        get() = field
        set(value) {
            field = value
        }

    var author_display: List<String> = listOf<String>()
        get() = field
        set(value) {
            field = value
        }


    var abstract: List<String> = listOf<String>()
        get() = field
        set(value) {
            field = value
        }
}
