package utils;


//Import Playwright's Page class.
// We need this because PageManager stores the current browser page.
import com.microsoft.playwright.Page;
public class PageManager {
        // ThreadLocal stores one Page object per test thread.
        // This is important when multiple tests run in parallel.
        // Each thread gets its own Page object.
        // Without ThreadLocal, different tests could overwrite each other's Page.
        private static final ThreadLocal<Page> page = new ThreadLocal<>();

        // Private constructor.
        // Prevents anyone from creating an object like:
        // new PageManager();
        // Since all methods are static, object creation is unnecessary.
        private PageManager() {
        }

        // Stores the current Playwright Page into ThreadLocal.
        // This will usually be called from BaseTest immediately after
        // page = browser.newPage();
        public static void setPage(Page page) {

            // "page" on the left refers to the ThreadLocal variable.
            // "page" inside the brackets is the method parameter.
            // We store the current Page in ThreadLocal.
            PageManager.page.set(page);
        }

        // Returns the current thread's Page.
        // Any class (Listener, ScreenshotUtil, Report, etc.)
        // can call this method to get the active Playwright page.
        public static Page getPage() {

            return page.get();
        }

        // Removes the Page from ThreadLocal.
        // This prevents memory leaks after the test finishes.
        // Usually called during test cleanup.
        public static void removePage() {

            page.remove();
        }
    }

