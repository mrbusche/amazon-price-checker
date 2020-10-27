package com.webpage.checker

import org.jsoup.Jsoup
import org.jsoup.nodes.TextNode
import org.springframework.stereotype.Service

@Service
class CheckerService {
    companion object {
        private const val PRICE_DROPS_CLASS = "a-column a-span12 g-span12when-narrow g-span7when-wide"
        private const val SECTION_LIST_ITEM_CLASS = "a-text-bold"

        fun retrieveByPriceDrop(url: String, percent: Boolean, drop: Int): List<String> {
            val document = Jsoup.connect(url).get()
            val elements = document.getElementsByClass(PRICE_DROPS_CLASS)
            val priceDropItems: MutableList<String> = mutableListOf()
            for (elem in elements) {
                val element = elem.attr("class", SECTION_LIST_ITEM_CLASS)
                if (element.childNode(1).childNodeSize() == 6 || element.childNode(1).childNodeSize() == 7) {
                    try {
                        val priceDrop = element.childNode(1).childNode(4).childNode(1).childNode(0).toString().replace("Price dropped ", "").replace("%", "").replace("$", "").trim().toInt()
                        val newPrice = element.childNode(1).childNode(2).childNode(1).childNode(1).childNode(0).childNode(0).toString().replace("$", "").toDouble()
                        val itemTitle = (element.childNode(0).childNode(0).childNode(0).childNode(0) as TextNode).wholeText
                        if (percent && priceDrop >= drop) {
                            priceDropItems.add(itemTitle)
                        }
                        if (!percent && drop >= newPrice) {
                            priceDropItems.add(itemTitle)
                        }
                    } catch (nfe: NumberFormatException) {
                        println(nfe.message)
                    } catch (ioe: IndexOutOfBoundsException) {
                        println(ioe.message)
                    }
                }
            }
            return priceDropItems
        }
    }
}
