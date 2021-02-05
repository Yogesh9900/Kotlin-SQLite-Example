package com.test.pfbtest.model

import android.provider.BaseColumns
import java.net.IDN

/**
 * Created by Yogesh Y. Nikam on 05/02/21.
 */
object DBContract {

    /* Inner class that defines the table contents */
    class DocsEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "docs"
            val ID = "id"
            val PUBLICATION_DATE = "publication_date"
            val ARTICLE_TYPE = "article_type"
        }
    }
}