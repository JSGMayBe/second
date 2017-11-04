package cn.tedu.ttms.common.web;

import java.io.Serializable;

/**灏佽鍏蜂綋鐨勫垎椤典俊鎭�*/
public class PageObject implements Serializable{
	@Override
	public String toString() {
		return "PageObject [pageCurrent=" + pageCurrent + ", pageSize=" + pageSize + ", rowCount=" + rowCount
				+ ", startIndex=" + startIndex + "]";
	}
	private static final long serialVersionUID = -8753809986545361268L;
	/**褰撳墠椤�*/
	private int pageCurrent=1;
	/**姣忛〉鏈�澶氳兘鏄剧ず鐨勮褰曟暟*/
	private int pageSize=3;
	/**鎬昏褰曟暟*/
	private int rowCount;
	/**涓婁竴椤电殑鏈�鍚庝竴鏉¤褰曚綅缃�
	 * 瀵瑰簲:limit startIndex,pageSize;
	 */
	private int startIndex;
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
	  	int pages = rowCount/pageSize;
    	if(0 != rowCount%pageSize) {
    		pages +=1;
    	}
        return pages;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	
	
	
	
	
	
}
