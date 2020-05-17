package money.master.views.learn;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import money.master.views.main.MainView;

@Route(value = "profile-learn", layout = MainView.class)
public class LearnView extends VerticalLayout{
    public LearnView() {
        add(new Text("It's hard to manage all your finances. What if everything was in one place?"));
        Accordion accordion = new Accordion();

        VerticalLayout loansLayout = new VerticalLayout();
        loansLayout.add(
                new Text("hi")
        );
        accordion.add("Managing Loans", loansLayout);

        VerticalLayout creditLayout = new VerticalLayout();
        creditLayout.add(
                new Text("Credit is super important in life. Credit gives you greater spending power as banks are willing " +
                        "to give you more money. " +
                        "But also, this offers you greater opportunities in life. Employers will look at your credit score, " +
                        "and a positive credit score will reflect greatly on you in terms of organization and responsibility. " +
                        "Landlords also receive your credit report, and this could be the dealbreaker to getting a good home. " +
                        "Overall, it’s essential to maintain credit\n"),
                new H1("So how do you build credit? First of all, you want to make sure your payments are all " +
                        "on time. This is probably the most key aspect. The next thing to keep in mind is consistency. " +
                        "Finally, staying out of debt is the last thing to keep in mind. While it seems rather obvious," +
                        " being in debt builds one up for failure. The stress and interest that follows debt will generally " +
                        "lead to more failure.\n"),
                new Text("Building Credit: Making sure all your payments (loans, bills) are on time. This is probably the most important " +
                        "Consistency — If you never slip up, your credit score will definitely rise "+
                        "Staying out of debt\n"),
                new Text("Consolidate your loans: "+
                           "If possible, transfer your loans onto another credit card before the teaser rates bump up. "+
                         "After transferring your debt balance, you can pay off more of your debt at 0% interest for some time. \n"),
                new Text("Do your own debt management: "+
                         "Credit counseling can be very expensive. Try to not get new debt. Cut back on spendings. "+
                         "Try to increase your income by asking for raises or looking for additional jobs. "+
                         "Others cannot help you with things you can’t do yourself. "+
                         "If worst comes to worst, local and government financial programs aimed at low-income families can help. "+
                         "There are also non profit organizations that help with credit management, "+
                         "such as debtor’s anonymous and the national foundation for credit counseling. \n"),
                new Text("Lower Your Interest Rate: "+
                         "Can you apply for low-interest credit cards? Can you take out a cheaper personal loan to pay off a more expensive loan? "+ 
                         "Financial institutions can have hardship programs, and bankers are sometimes willing to negotiate!\n")
        );
        accordion.add("Billing Address", creditLayout);

        VerticalLayout bankLayout = new VerticalLayout();
        bankLayout.add(
                new Text("hi")
        );
        accordion.add("Payment", bankLayout);

        VerticalLayout sideCashLayout = new VerticalLayout();
        sideCashLayout.add(
                new Text("Disclaimer: this list contains lots of opportunities, but" +
                        "some may not be appropriate for your situation. Pick and choose " +
                        "the best job for you. With that being said, we wish you all the best" +
                        " in your financial endeavors."),
                new H1("If you have a lot of free time: \n"),
                new Text("Uber/Lyft: This won’t make an impressive amount of money, and the amount you net really depends " +
                        "on where you live, but it’s better than nothing. This also offers an opportunity to build up social " +
                        "skills, which can be useful in getting different opportunities in life.\n"),
                new Text("Delivery Services: Similar to Uber/Lyft, except now there’s food in place of a person. Again, " +
                        "money will not be the best, but you might get tipped. If you’re not in a highly trafficked area " +
                        "like New York, this might not be the job for you. Examples include Postmates and Grubhub. \n"),
                new Text("Mystery Shopper: These shoppers are sort of private investigators on retail stores, documenting " +
                        "customer service experience to the cleanliness of the environment. Lots of scams exist, so be " +
                        "sure to check out https://www.mspa-global.org/ if you’re interested. \n"),
                new Text("Part-time job: This is rather self explanatory. Reach out to any local businesses if they're" +
                        " still hiring, and you should be able to get a part-time job. Most of the time, you don't need " +
                        "too high qualifications. \n"),
                new Text("Remote jobs: Try finding low-maintenance jobs like a social media manager or a content creator. " +
                        "You don’t need to show up for work, and you’ll likely have flexible work times. Combined, if " +
                        "jobs as described above fit under your skill set, this should be a stress-free way to get " +
                        "some easy money.\n"),
                new H1("If you have a degree in an area: \n"),
                new Text("Making an online course on Coursera and Udemy in your free time: once you’re done, and if you " +
                        "can gain traction, this will net a lot of passive income. Moreover, assuming your first course " +
                        "goes well, you now have some clout, so making a second course will likely generate money much " +
                        "faster. \n"),
                new Text("E-book or Audio book: Creating an E-book is much easier than having to print it out, and if " +
                        "you successfully create an Ebook and it is rather popular, then you’ll have an opportunity to " +
                        "print it out and make even more money. Audiobooks follow closely behind as well.\n"),
                new Text("Writing online articles/starting a blog — a blog in particular will take time to gain traction, " +
                        "but overall this has the potential to net lots of passive income. Check out websites like medium.\n"),
                new H1("If you're somewhat crunched for time: "),
                new Text("Ebay/Craigslist/Amazon: sell anything used that you won’t need. Put it up, and then just wait " +
                        "for an offer\n"),
                new Text("Renting a room on Airbnb: if you have a spare room, consider renting it out or looking for a " +
                        "roommate to pay part of the rent. A good roommate can be a nice change of life, and it also " +
                        "improves your social network.\n")
        );
        accordion.add("Payment", sideCashLayout);
        
        add(accordion);
    }



}
