# Instructions

In this exercise we will implement a typical usecase: Filtering and transforming a collection of data. Think of a web store with a overview over all products. The user is capable to navigate the pages of products and also to filter and sort them. In a real application the product items are typically received from a database. In this case for simplicity they are provided as an array. The exercise could also be solved with already known language features like for-loops and if-conditions, but for this one you are intended to use Java Streams. If you want you can do both, first without Streams and then with Streams to see the difference between these styles and form your own opinion about the optional Java Stream feature.

The method to implement receives the following parameters:

* **Item[] items**: An array with all items available. These items should be filtered and transformed by the rules of the following parameters.
* **int offset**: How many items should be skipped in the result. As example if the user navigates the second page of items and each page shows 10 items then the value passed here would be 10. If this value is greater or equal then the available item count then the result should be empty. Important: The available items to which this offset should be applied to have to be reduced by the `titlePrefix` first.
* **int limit**: The maximum amount of items that should be contained in the result. If the page size is 10 then the limit would be 10.
* **String titlePrefix**: Can be `null`. If not `null` only the items that have a title beginning with this prefix should be included in the result.
* **SortBy sortBy**: Can be `null`, `SortBy.ID` or `SortBy.TITLE`. Depending on the value, sorting should be based on the item id or the item title.
* **boolean desc**: If `true` then the order of the result items should be descending. Otherwise ascending.

The method have to return a `List<Item>` containing all items matching the given criteria.

