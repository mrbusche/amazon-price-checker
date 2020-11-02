# amazon-price-checker

# Getting started
- Fork this repository
- Update the [test file](https://github.com/mrbusche/amazon-price-checker/blob/main/src/test/kotlin/CheckerApplicationTests.kt) with your values

## Test by maxium price
- Update [`priceDropUrl`](/src/test/kotlin/CheckerApplicationTests.kt#L7) to your Amazon wishlist. It _must_ have `?sort=universal-price` appended to it or it won't pull all items.
- Update [`maxPrice`](/src/test/kotlin/CheckerApplicationTests.kt#L8) to the maximum price you're willing to pay
- Delete the test around [price drop percentage](/src/test/kotlin/CheckerApplicationTests.kt#L21-L26)
- Tests run automatically every [2 hours](amazon-price-checker/blob/main/.github/workflows/gradle.yml#L12)

## Test by price drop percentage
- Update [`percentDropUrl`](/src/test/kotlin/CheckerApplicationTests.kt#L11) to your Amazon wishlist. It _must_ have `?sort=universal-price` appended to it or it won't pull all items.
- Update [`priceDropPercent `](/src/test/kotlin/CheckerApplicationTests.kt#L12) to the minimum price drop percentage you care about
- Delete the test around [maximum price](/src/test/kotlin/CheckerApplicationTests.kt#L14-L19)
- Tests run automatically every [2 hours](amazon-price-checker/blob/main/.github/workflows/gradle.yml#L12)
