var DataTable = Vue.extend({
	props : [ "url" ],
	template : "#data-table-template",
	data : function() {
		return {
			"pageSizeList" : [ 5, 10, 25, 50, 100 ],
			"pageSize" : 10,
			"sort" : "",
			"dir" : "asc",
			"content" : [],
			"paginator" : {
				"totalElements" : 0,
				"currentPage" : 0,
				"pageSize" : 10,
				"totalPages" : 0,
				"startPage" : 0,
				"endPage" : 0,
				"startIndex" : 0,
				"endIndex" : 0,
				"pages" : [],
				"pageInfo" : ""
			}
		};
	},
	methods : {
		gotoPage : function(pageNumber) {
			var str = this.getUrl(pageNumber, this.pageSize, this.sort,
					this.dir);
			this.$http.get(str).then(
					function(response) {
						var body = response.body;
						this.content = body.content;
						var currentPage = body.number;
						var pageSize = body.size;
						var totalPages = body.totalPages;
						var totalElements = body.totalElements;
						this.updatePaginator(currentPage, pageSize, totalPages,
								totalElements);
					}, function(response) {
						console.log(response);
					});
		},
		getUrl : function(page, size, sort, dir) {
			var str = "http://localhost:8080/persons?page=" + page;
			str = str + "&size=" + size;
			str = str + "&sort=" + sort;
			str = str + "," + dir;
			return str;
		},
		orderBy : function(key) {
			this.sort = key;
			this.dir = (this.dir === 'asc') ? 'desc' : 'asc';
			this.gotoPage(this.currentPage);
		},
		updatePaginator : function(currentPage, pageSize, totalPages,
				totalElements) {
			currentPage = currentPage || 0;
			// default page size is 10
			pageSize = pageSize || 10;
			var startPage, endPage;
			if (totalPages <= 10) {
				// less than 10 total pages so show all
				startPage = 0;
				endPage = totalPages;
			} else {
				// more than 10 total pages so calculate start and end pages
				if (currentPage <= 6) {
					startPage = 0;
					endPage = 10;
				} else if (currentPage + 4 >= totalPages) {
					startPage = totalPages - 9;
					endPage = totalPages;
				} else {
					startPage = currentPage - 5;
					endPage = currentPage + 4;
				}
			}

			// calculate start and end item indexes
			var startIndex = (currentPage) * pageSize;
			var endIndex = Math.min(startIndex + pageSize - 1, totalElements);
			// create an array of pages to v-for in the pager control
			var pages = [];
			for (var i = startPage; i < endPage; i++) {
				pages.push(i);
			}
			// return object with all pager properties required by the view
			var pageInfo = "Showing " + startIndex + " to " + endIndex + " of "
					+ totalElements + " entries ";
			this.paginator.totalElements = totalElements;
			this.paginator.currentPage = currentPage;
			this.paginator.pageSize = pageSize;
			this.paginator.totalPages = totalPages;
			this.paginator.startPage = startPage;
			this.paginator.endPage = endPage;
			this.paginator.startIndex = startIndex;
			this.paginator.endIndex = endIndex;
			this.paginator.pages = pages;
			this.paginator.pageInfo = pageInfo;
		}
	},
	ready : function() {
		this.gotoPage(0);
	}
});

Vue.component('data-table', DataTable);