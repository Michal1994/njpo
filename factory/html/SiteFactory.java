package factory.html;

public class SiteFactory {
	
	public enum SiteType {
		Contact, Gallery, Info, News;
	}
	
	public static Site makeSite(SiteType type){
		
		switch(type){
		
		case Contact:{
			return new ContactSite();
		}
		case Gallery:{
			return new GallerySite();
		}
		case Info:{
			return new InfoSite();
		}
		case News:{
			return new NewsSite();
		}
		default: return null;
		
		}
		
	}
	
}
