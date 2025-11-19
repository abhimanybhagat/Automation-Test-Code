from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
import time

def test_price_filter(min_shift=30, max_shift=-40):
    driver.get("https://test.bishalkarki.com")
    time.sleep(3)

    # Scroll to price filter area
    driver.execute_script("window.scrollBy(0, 600)")

    # Identify slider handles
    left_handle = driver.find_element(By.CSS_SELECTOR, ".ui-slider-handle:nth-child(2)")
    right_handle = driver.find_element(By.CSS_SELECTOR, ".ui-slider-handle:nth-child(3)")

    action = ActionChains(driver)

    # Move left handle right
    action.click_and_hold(left_handle).move_by_offset(min_shift, 0).release().perform()
    time.sleep(2)

    # Move right handle left
    action.click_and_hold(right_handle).move_by_offset(max_shift, 0).release().perform()
    time.sleep(4)

    # Collect product prices
    prices = driver.find_elements(By.CSS_SELECTOR, ".price.product-price")

    extracted_prices = []

    for p in prices:
        price_text = p.text.replace("$", "").strip()
        if price_text == "" or not price_text.replace('.', '').isdigit():
            continue

        extracted_prices.append(float(price_text))

    print("Extracted prices:", extracted_prices)

    # Verify all products fall inside range
    min_price = min(extracted_prices)
    max_price = max(extracted_prices)

    print(f"Lowest price: {min_price}")
    print(f"Highest price: {max_price}")

    assert min_price >= 16, "❌ Price lower than expected!"
    assert max_price <= 50, "❌ Price higher than expected!"

    print("✔ PRICE FILTER TEST PASSED!")


# MAIN
driver = webdriver.Chrome()
driver.maximize_window()

test_price_filter()

driver.quit()
