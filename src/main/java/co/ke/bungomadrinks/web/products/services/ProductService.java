package co.ke.bungomadrinks.web.products.services;

import co.ke.bungomadrinks.web.products.models.Product;
import co.ke.bungomadrinks.web.products.models.ProductCategory;
import co.ke.bungomadrinks.web.products.models.ProductOption;
import co.ke.bungomadrinks.web.products.repositories.ProductCategoryRepository;
import co.ke.bungomadrinks.web.products.repositories.ProductOptionRepository;
import co.ke.bungomadrinks.web.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository prodRepository;
    private final ProductOptionRepository productOptionRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductService(ProductRepository prodRepository,
                          ProductOptionRepository productOptionRepository,
                          ProductCategoryRepository productCategoryRepository) {
        this.prodRepository = prodRepository;
        this.productOptionRepository = productOptionRepository;
        this.productCategoryRepository = productCategoryRepository;
    }


    public void addProducts() {

        prodRepository.saveProduct(new Product(
                "Gilbey's Gin",
                3,
                "Gilbey’s Gin is a classic juniper-led London Dry Gin. It is crystal clear with light, floral aromas of juniper along with hints of sweet orange. The palate is clean, light, and dry. Assertive and sharp with a presence of botanicals, juniper, bitter orange rind, and coriander. The finish is moderately long with lingering citrus notes. Gilbey’s Gin is distilled from grain neutral spirits along with 12 other botanicals. It has a reputation of being an inexpensive gin. It may be enjoyed on its own, part of a mixed drink, or a base for cocktails.",
                "gilbeys-gin.jpg",
                "Gin"));

        prodRepository.saveProduct(new Product(
                "Gordon's London Dry Gin",
                4,
                "Almost 250 years ago, Alexander Gordon started his distillery in London and set about creating the recipe for a brilliant tasting gin. Gordon's high quality and distinctive juniper flavour has come to define the taste of the classic G&T. \n Gordon's today is a gin that's enjoyed, not dissected. It's the perfect gin to start a Friday evening, or a Tuesday night catch up with friends, where we share a moment and have a laugh with people we love.",
                "GORDONS-GIN.jpg",
                "Gin"));

        prodRepository.saveProduct(new Product(
                "Johnnie Walker Red Label",
                7,
                "Flowers that bloom into flames. Johnnie Walker Red Label is the world’s best-selling Scotch Whisky. And is made for mixing, both in exhilarating cocktails and with your favorite people. It brings together whiskies specially chosen for their bold, vibrant flavors that add a fiery kick to any mix.",
                "JOHNNIE-WALKER-RED.jpg",
                "Whisky"));

        prodRepository.saveProduct(new Product(
                "Johnnie Walker Black Label",
                9,
                "Johnnie Walker Black Label is one of life’s true icons. A masterful blend of single malt and grain whiskies from across Scotland, aged for at least 12 years. The result is a timeless classic with depth and balance of flavor. Drink it with ice, neat or in a Highball.",
                "johnnie-walker-black-label.jpg",
                "Liqueur"));

        prodRepository.saveProduct(new Product(
                "Amarula",
                10,
                "Amarula is a famous cream liqueur with its origin in South Africa. This cream is made with sugar, cream and the fruit of the African marula tree. This drink has been widely accepted, everybody who has tasted this drinks can testify that this liqueur is the true definition of awesomeness.",
                "amarula.jpg",
                "Liquer"));

        prodRepository.saveProduct(new Product(
                "Tanqueray",
                11,
                "There is no doubt that Tanqueray is one of the most iconic gins of all time. You can easily spot the beautiful green bottle from the other side of the bar in almost any country in the world. Tanqueray is a gin produced by Charles Tanqueray in 1830, which has held its unique style to this day. Tanqueray is a so-called London Dry Gin, meaning that the spice mixture used is either a distilled essence or has been leached into the spirit before distillation. Charles Tanqueray was from a clergy's family but decided not to follow the family's calling but instead opened a distillery in Bloomsbury, London. He was not afraid to mix up bold ideas in his unique style; he invented a gin celebrated to this day. The recipes were often inspired by new spices that came to London from countries in the Far East. In 1898 Tanqueray merged with Gordons and became the largest gin house in ages. To date, Tanqueray Gordon is part of Diageo.",
                "tanqueray.jpg",
                "Gin"));

        prodRepository.saveProduct(new Product(
                "Cellar Cask Red",
                12,
                "Cellar Cask Red is a brand of red wine that originated in the United States.",
                "cellar-cask-red.jpg",
                "Wine"));

        prodRepository.saveProduct(new Product(
                "Singleton",
13,
                "The Singleton is about smoothness, and making first-rate single malt whisky with a quality that experts call ‘welcoming’. The brand rose in the late 19th century, united by a single vision to create fantastic single malt whiskies. Glen Ord is one of the oldest distilleries in Scotland, found on the Black Isle in the Scottish Highlands. Despite the three distilleries sharing a name they have separate Malt Masters, and each distillery is focussed on its own vision.",
                "singleton.jpg",
                "Whisky"));

        prodRepository.saveProduct(new Product(
                "Johnnie Walker Green Label",
                14,
                "Created by legendary Master Blender Dr. Jim Beveridge and his team, Johnnie Walker Green Label is described by whisky expert Dave Broom as, \"An arresting, pure malt-whisky with vibrant, natural notes of forest, shore and fruit. The different elements are all in evidence yet also in harmony. Concentrated flavours have been brought together and work together as a whole whilst retaining their individuality. It changes every time you pick up the glass.\"Charles Maclean's official tasting notes: Deep amber in colour, initially somewhat closed, then subtle scents of dry Xmas cake, complete with marzipan, icing sugar and waxed wrapper, being to emerge. A smooth, rich texture, and a sweet, dry-fruit mouth taste, with milk chocolate baking spices and a trace of ginger. Drinks well straight.",
                "johnnie-walker-green-label.jpg",
                "Whisky"));

        prodRepository.saveProduct(new Product(
                "Hunter's Choice",
15,
                "Hunter’s Choice is one of Kenya’s finest blended whiskies. Hunters Choice Whisky is a very aromatic whiskey with hints of peat and fruit.  A specially blended fine whisky: rich, smooth and mellow drink for the discerning drinker. It reflects the spirit of adventure and is the perfect drink to travel with for parties and camping trips",
                "hunters-choice.jpg",
                "Whisky"));

        prodRepository.saveProduct(new Product(
                "VAT 69",
18,
                "VAT 69 is a brand of Blended Scotch Whisky by William Sanderson & Son LimitedDiageo. The brand dates back to 1882 when it was established by William Sanderson.\n" +
                        "\n" +
                        "VAT 69 Whisky is enjoyed by many for it's gently smoky, smooth characteristics.",
                "vat-69.jpg",
                "Whisky"));

        prodRepository.saveProduct(new Product(
                "Chrome Gin",
                20,
                "Chrome Gin is a smooth and crisp gin inspired by the exuberance of the streets and recognizes the vibrant urban consumer. You are guaranteed to enjoy a high-quality gin experience that is invigorating, refreshing and crisp. Best enjoyed neat or with a flavored mix.",
                "chrome-gin.jpg",
                "Gin"));

        prodRepository.saveProduct(new Product(
                "Captain Morgan",
                21,
                "To make the perfect dark rum to keep the Captain’s men going across the seven seas, Captain Morgan Dark Rum is aged for that heavenly oak finish, before being blended according to our very own secret recipe.\n" +
                        "\n" +
                        "The smooth, rich and oaky taste of Captain Morgan Dark Rum makes it the perfect tipple to be drunk neat or moored on the rocks.\n" +
                        "For a real rum punch, you can mix into one of the Captain’s favourite dark rum cocktails.",
                "captain-morgan.jpg",
                "Rum"));

        prodRepository.saveProduct(new Product(
                "Captain Morgan Gold",
22,
               "Avast ye! Take a sip and lift it to your nose, just the way the Captain did when he first created his sumptuous spiced spirit drink. You’ll taste notes of rich vanilla, brown sugar, warming spices with just the hint of oak. They all combine for balance, a smooth finish and the perfect drink for buccaneers and landlubbers alike.",
                "Capt-Morgan-Gold.jpg",
                "Rum"));

        prodRepository.saveProduct(new Product(
                "Captain Morgan Spiced",
23,
                "Avast ye! Take a sip and lift it to your nose, just the way the Captain did when he first created his sumptuous spiced spirit drink. You’ll taste notes of rich vanilla, brown sugar, warming spices with just the hint of oak. They all combine for balance, a smooth finish and the perfect drink for buccaneers and landlubbers alike.",
                "Capt-Morgan-Gold.jpg",
                "Rum"));

        prodRepository.saveProduct(new Product(
                "Richot Brandy",
26,
                "Richot Brandy is a premium, full bouquet, well-matured grape brandy meant for the discerning consumer who does not compromise on quality. Matured in single oak casks in Italy, Richot Brandy is rated Perfect Blend meaning it is a blend of the best grapes matured in wood for at least 5 years.",
                "richot.jpg",
                "Brandy"));

        prodRepository.saveProduct(new Product(
                "Viceroy",
                28,
                "Viceroy is a brand of Brandy made by Viceroy Vineyards. Viceroy is a premium, full bouquet, well-matured grape brandy meant for the discerning consumer who does not compromise on quality. Matured in single oak casks in Italy, Viceroy is rated Perfect Blend meaning it is a blend of the best grapes matured in wood for at least 5 years.",
                "viceroy.jpg",
                "Brandy"));

        prodRepository.saveProduct(new Product(
                "Smirnoff Vodka",
32,
                "Smirnoff red is a Russian vodka made using the traditional charcoal filtration method. It is triple distilled and exceptionally smooth, then ten times filtered in a unique process for ultimate clarity. Enjoyed all over the world in cocktails and in mixed drinks.\n" +
                        "\n" +
                        "Smirnoff Red is crystal clear in appearance with a clean aroma of faint black pepper and charcoal. It has a subtle minerality on the palate with notes of cracked black pepper spice and a faint sensation of peppermint freshness. The finish is delicate with notes of black pepper spice with chargrilled peppers. It is enjoyed world over on its own or as a base for most mixed drinks.",
                "smirnoff-red-vodka.jpg",
                "Vodka"));

        prodRepository.saveProduct(new Product(
                "Bailey's Original",
                34,
                "Baileys Original Irish Cream is a unique marriage of fresh, dairy cream, Irish whiskey, finest spirits and natural flavours.\n" +
                        "\n" +
                        "When you take a sip of Baileys, the pleasure comes in waves. The cream melts releasing the whiskey, which slips down, warming your taste buds, the chocolate delights your tongue, whilst the thick silky cream coats your mouth. It's a truly memorable experience. Baileys is best enjoyed blended or shaken with ice.",
                "bailey-s.jpg",
                "Liqueur"));

        prodRepository.saveProduct(new Product(
                "Caprice Dry Red",
                35,
                "Caprice dry red wine is made from a blend of specially selected red grapes harvested at optimum conditions in South Africa.\n" +
                        "\n" +
                        "It goes well with all red meat and spicy dishes. Its deep ruby colour and pleasant taste makes it the perfect wine to enjoy with friends.\n" +
                        "\n" +
                        "Best enjoyed cool.",
                "caprice-dry-red-table-wine.jpg",
                "Wine"));

        prodRepository.saveProduct(new Product(
                "4th Street",
                36,
                "4th STREET wines are made from quality grapes sourced from selected vineyards throughout the Western Cape.4th STREET grapes are harvested in February and March at optimum ripeness to ensure a maximum burst of fruity nectar. Standard wine-making practices are followed to produce the red and white base wines. The fresh sweetness comes from careful blending of the light, fruity wine and the full sweet grape juice resulting in an easy-drinking, low-alcohol wine.\n" +
                        "\n" +
                        "4th STREET natural sweet red wine is easy to drink, fresh, and naturally sweet. 4th STREET is a wine inspired by a passion for friendship and sharing. That’s why wherever there are good times, there’s 4th STREET red wine. When it’s time to get together with friends it’s time to open 4th STREET which is naturally sweet and bursts with fruity flavors and complements every occasion.",
                "4-th-street.jpg",
                "Wine"));

        prodRepository.saveProduct(new Product(
                "Caprice Sweet Red",
                37,
                "Caprice Dry Red is a wine produced from Monastrell Black Grapes. The wine gets its dark color from the long fermentation of the grapes skin until their sugar content has been converted into alcohol.\n" +
                        "\n" +
                        "Caprice Dry Red pairs well with all types of meat, including game meat. It can also be served with cheese.",
                "caprice-sweet-red.jpg",
                "Wine"));

        prodRepository.saveProduct(new Product(
                "Casa Buena Sweet Red",
                38,
                "Casa Buena is a high-quality ready-to-drink Sangria which is alcohol made by blending wine and fruits. Packaged in 1 Litre Tetra Packs. Best served chilled.",
                "Casa-Buena-Sangaria-1ltr-1.jpg",
                "Wine"));

        prodRepository.saveProduct(new Product(
                "Alvaro",
                39,
                "Introduced in Kenya in March 2008, Alvaro is a unique refreshing natural malt drink. It is packaged in a stylish embossed green bottle with contemporary metallic labelling giving it that sophisticated and outstanding look.",
                "alvaro.jpg",
                "Soft Drink"));

        prodRepository.saveProduct(new Product(
                "Smirnoff Ice",
                40,
                "Smirnoff Ice Black is a premium triple filtered vodka with the taste of lemon. It is a favourite premix Vodka due to its light citrus flavouring balanced with triple distilled vodka for that authentic taste. Perfect for enjoying on hot days with great friends.\n" +
                        "\n" +
                        "Smirnoff Ice Black cans have a refreshing and extra strong blend of Smirnoff Vodka and tangy citrus flavoured soda. A modern tribute to the traditional standards established by Smirnoff and now conveniently packaged in cartons, Smirnoff Black is perfect for parties or sharing with great friends after work.",
                "smirnoff-ice.jpg",
                "Canned"));

        prodRepository.saveProduct(new Product(
                "Snapp",
                41,
                "Snapp is a naturally refreshing, fruit flavored alcoholic drink for the contemporary, sophisticated and chic woman. It is curated with a delightful apple savor for that distinctive ultra-modern crisp taste. Snapp salutes today’s woman; she is empowered, assertive and elegant. It supplements her womanhood, way of life and accomplishments.",
                "snapp.jpg",
                "Canned"));

        prodRepository.saveProduct(new Product(
                "Tusker Lager",
                42,
                "Refresh Your Roots The name TUSKER came about as a memorial following the death of George Hurst a co-founder of Kenya Breweries Ltd who was killed by an elephant during a hunting expedition in 1922. The brand has since grown to be EABL's flagship brand. TUSKER is brewed from 100% African ingredients that are all locally sourced; the barley is from the Savannah and the Maasai Mara, the spring water is from the Aberdare Mountains and all the yeast is developed locally which means that you feel closely connected to the brand's origins and roots.",
                "tusker-lager.jpg",
                "Canned"));

        prodRepository.saveProduct(new Product(
                "White Cap Lager",
                43,
                "White Cap Lager is named after the magnificent snow-capped Mount Kenya. Boasting of consistent quality, White Cap is unique and full of character. It is the connoisseur's beer.",
                "white-cap.jpg",
                "Canned"));

        prodRepository.saveProduct(new Product(
                "Pilsner Lager",
                44,
                "Pilsner Lager's style of brewing is inspired by the original process of brewing the first Pilsner in Eastern Europe. Through the years, East African brewmasters have maintained this unique process which involves cold filtering the beer giving it that superior liquid clarity and authentic taste.",
                "pilsner.jpg",
                "Canned"));

        prodRepository.saveProduct(new Product(
                "Tusker Lite",
                45,
                "TUSKER LITE was introduced into the East African market in 2011 as a low carb beer uniquely brewed with natural ingredients.\n" +
                        "\n" +
                        "Tusker Lite delivers an easy drinking experience. It's time to take it easy. Easy going is all about a true enthusiasm for life, which enhances shared experiences and camaraderie, a good sense of humour, always has a positive outlook on things. An easy drinking experience is enjoying a fulfilling lifestyle and relaxing with friends after a day's work over a cold bottle of TUSKER LITE.",
                "tusker-lite.jpg",
                "Canned"));

        prodRepository.saveProduct(new Product(
                "Tusker Cider",
                46,
                "Tusker Premium Cider. It is the first locally-produced cider in East Africa and made in Kenya. Tusker Cider is a deliciously crisp, premium-crafted and refreshing drink created from fresh apples, perfectly balanced for a drinking experience. It delivers a rich fruit flavour and a sharp, crisp finish that is lightly carbonated and super refreshing. A cider is an alcoholic drink made from crushed fruit, typically apples.",
                "tusker-cider.jpg",
                "Canned"));

        prodRepository.saveProduct(new Product(
                "Tusker Malt",
                47,
                "100% Malt Brewed As EABL's first premium brand, TUSKER MALT Lager was initially launched in the Kenyan market in 1996 after years as an export only brand. TUSKER MALT Lager is brewed for longer than other contemporary lagers giving it that unmistakably rich, smooth premium taste that is widely recognized and that consumers have grown to love.",
                "tusker-malt.jpg",
                "Canned"));

        prodRepository.saveProduct(new Product(
                "Guiness Stout",
                48,
                "When Arthur Guinness signed a 9,000 year lease on his brewery at St. James’s Gate, Dublin, it was a statement of belief in the beer he brewed. Now, over 260 years later, Guinness is the world’s favourite stout, with more than 10 million glasses sold every day across 150 countries.",
                "guiness-stout.jpg",
                "Canned"));

        prodRepository.saveProduct(new Product(
                "Balozi Lager",
                49,
                "Balozi Lager was launched into the Kenyan market on the 21st December 2012 after a series of consumer trials. It is a rich, natural tasting beer made from pure water originating from the heart of the Aberdares and the finest malted barley with no added sugar.",
                "balozi-lager.jpg",
                "Canned"));





    }


    public List<Product> getAllProducts() {
        return prodRepository.getAllProducts();
    }

    public Product getProduct(Long id) {
        return prodRepository.getProduct(id);
    }

    public void addProduct(Product product) {
        prodRepository.saveProduct(product);
    }

    public void updateProduct(Long id, Product product) {
        product.setProductUpdateDate(new Timestamp(System.currentTimeMillis()));
        prodRepository.updateProduct(id, product);
    }

    public void deleteProduct(Long id) {
        prodRepository.deleteProduct(id);
    }

    public List<ProductOption> getProductOptions(Long id) {
        return prodRepository.getProductOptions(id);
    }

    public void addProductOption(Long id, ProductOption productOption) {
        Product product = prodRepository.getProduct(id);
        product.setProductUpdateDate(new Timestamp(System.currentTimeMillis()));
        product.addProductOption(productOption);
        prodRepository.updateProduct(id, product);
    }

    public void updateProductOption(Long id, Long optionId, ProductOption productOption) {
        Product product = prodRepository.getProduct(id);
        product.setProductUpdateDate(new Timestamp(System.currentTimeMillis()));
//        product.updateProductOption(optionId, productOption);
        productOptionRepository.updateProductOption(optionId, productOption);
        prodRepository.updateProduct(id, product);
    }

    public void deleteProductOption(Long id, Long optionId) {
        Product product = prodRepository.getProduct(id);
        product.setProductUpdateDate(new Timestamp(System.currentTimeMillis()));
        productOptionRepository.deleteProductOption(optionId);
        prodRepository.updateProduct(id, product);
    }

    public ProductOption getProductOptionById(Long id, Long optionId) {
        return productOptionRepository.getProductOptionById(optionId);
    }

    public List<ProductCategory> getProductCategories(Long id) {
        return prodRepository.getProductCategories(id);
    }

    public ProductCategory addProductCategory(Long id, ProductCategory productCategory) {
        productCategoryRepository.addProductCategory(id, productCategory);
        return productCategory;
    }

    public ProductCategory updateProductCategory(Long id, Long categoryId, ProductCategory productCategory) {
        productCategoryRepository.updateProductCategory(categoryId, productCategory);
        return productCategory;
    }

    public void deleteProductCategory(Long id, Long categoryId) {
        productCategoryRepository.deleteProductCategory(categoryId);
    }

    public ProductCategory getProductCategory(Long id, Long categoryId) {
        return productCategoryRepository.getProductCategory(categoryId);
    }
}
