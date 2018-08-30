
[Getting Started](https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started.html)

Elasticsearch is a highly scalable open-source full-text search and analytics engine. It allows you to store, search, and analyze big volumes of data quickly and in near real time. It is generally used as the underlying engine/technology that powers applications that have complex search features and requirements.

Here are a few sample use-cases that Elasticsearch could be used for:

You run an online web store where you allow your customers to search for products that you sell. 
In this case, you can use Elasticsearch to store your entire product catalog and inventory and provide search and autocomplete suggestions for them.

You want to collect log or transaction data and you want to analyze and mine this data to look for trends, statistics, summarizations, or anomalies. In this case, you can use Logstash (part of the Elasticsearch/Logstash/Kibana stack) to collect, aggregate, and parse your data, and then have Logstash feed this data into Elasticsearch. Once the data is in Elasticsearch, you can run searches and aggregations to mine any information that is of interest to you.

You run a price alerting platform which allows price-savvy customers to specify a rule like "I am interested in buying a specific electronic gadget and I want to be notified if the price of gadget falls below $X from any vendor within the next month". In this case you can scrape vendor prices, push them into Elasticsearch and use its reverse-search (Percolator) capability to match price movements against customer queries and eventually push the alerts out to the customer once matches are found.

You have analytics/business-intelligence needs and want to quickly investigate, analyze, visualize, and ask ad-hoc questions on a lot of data (think millions or billions of records). In this case, you can use Elasticsearch to store your data and then use Kibana (part of the Elasticsearch/Logstash/Kibana stack) to build custom dashboards that can visualize aspects of your data that are important to you. Additionally, you can use the Elasticsearch aggregations functionality to perform complex business intelligence queries against your data.

For the rest of this tutorial, you will be guided through the process of getting Elasticsearch up and running, taking a peek inside it, and performing basic operations like indexing, searching, and modifying your data. At the end of this tutorial, you should have a good idea of what Elasticsearch is, how it works, and hopefully be inspired to see how you can use it to either build sophisticated search applications or to mine intelligence from your data.

# 开始
ES 是一个具有高扩展、全文搜索的、开源特点的分析引擎。它可以提供几乎实时的存储、搜索以及大量数据的分析能力。通常 es 被作为底层引擎或工具用来为您的应用提供复杂的查询能力。

下面是一些 es 可以被使用的简单场景。

1)您运行在线网上商店，允许您的客户搜索您销售的产品。 在这种情况下，您可以使用Elasticsearch存储整个产品目录和库存，并为它们提供搜索和自动填充建议。 --> suggestion

2)您希望收集日志或交易数据，并且希望分析和挖掘此数据以查找趋势，统计信息，摘要或异常。 在这种情况下，您可以使用Logstash（Elasticsearch / Logstash / Kibana堆栈的一部分）来收集，聚合和解析数据，然后让Logstash将此数据提供给Elasticsearch。 一旦数据在Elasticsearch中，您就可以运行搜索和聚合来挖掘您感兴趣的任何信息。

3)您运行价格警报平台，允许精通价格的客户指定一条规则，例如“我有兴趣购买特定的电子产品，如果小工具的价格在下个月内从任何供应商降至X美元以下，我希望收到通知”。 在这种情况下，您可以爬取供应商价格，将其推入Elasticsearch并使用其反向搜索（Percolator）功能来匹配价格变动与客户查询，并最终在发现匹配后将警报推送给客户。

4)您有分析/业务智能需求，并希望快速调查，分析，可视化并询问有关大量数据的特定问题（想想数百万或数十亿条记录）。 在这种情况下，您可以使用Elasticsearch存储数据，然后使用Kibana（Elasticsearch / Logstash / Kibana堆栈的一部分）构建自定义仪表板，以便可视化对您来说重要的数据方面。 此外，您可以使用Elasticsearch聚合功能针对您的数据执行复杂的商业智能查询。

在本教程的其余部分中，将引导您完成启动和运行Elasticsearch，查看其中的内容以及执行索引，搜索和修改数据等基本操作的过程。 在本教程结束时，您应该很好地了解Elasticsearch是什么，它是如何工作的，并希望能够启发它，看看如何使用它来构建复杂的搜索应用程序或从数据中挖掘智能。

