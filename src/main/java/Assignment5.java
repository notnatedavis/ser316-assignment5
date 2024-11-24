// import x; // might need later

/**
  * Assignment5.java
  * @author Nathaniel Davis-Perez [ndavispe]
  * @since 11/19/2024
  */

/*
 *   Silicon-Valley Simulator Assignment
 *   Requirements : 
 *      Player vs Bot (turn based game within terminal)
 *      1. Initial Setup
 *         - the simulation starts with 2 Tech Giants, each w/ 1 Startup (they each have initial $ amount)
 *         - each Tech Giant's startup are distinct and have their own unique attributes
 *           ex. market share growth rate, revenue loss / gain rate, unique impact with events
 *           event types ex. Social Media, Military, Medical, Tech
 *         - startups can be selected, random, or random from selected type (3 options)
 *         - (note: brainstorm 5 types w/ 5 startups per type)
 *         - (note: brainstorm 5-10 attributes for startup)
 *      2. Cycles & events
 *         - simulation progresses in yearly cycles (Q1 , Q2 , Q3 , Q4)
 *         - each quarter has a chance to summon a random event
 *           Q1: Corporate Tax Cuts (neutral)
 *           Q2: Economic Downturn (hurts some types, boosts others)
 *           Q3: Regulatory Scrutiny (hurts larger startups, boosts smaller ones)
 *           Q4: Competitive Battles (Tech Giants face off)
 *         - Random Events : market crash, market boom, housing crisis, housing boom, slow growth, slow decline
 *      3. Market Dynamics
 *         - events can benefit or disadvantage startups depending on their type
 *           Economic Downturn: boosts Healthcare startups by 20%, but reduces FinTech revenue by 20%.
 *           Regulatory Scrutiny: reduces Market Share for Startups with more than 25% Market Share and boosts it for smaller Startups by 10%.
 *      4. Types and Battle Advantages
 *         - Startups should be categorized by type
 *         - each type has natural advantage over certain types
 *      5. Quarterly Activities
 *         - during the 4th quarter Tech Giants fight 
 *             - winning = $ gain + boost attributes (+0.1% startup growth rate)
 *             - losing = $ lost + decline attributes (-0.1% startup growth rate)
 *         - during odd quarters (Q1 & Q3) tech giants may
 *             - invest $ to increase attributes
 *             - attempt to buy new startups / sell startups
 *      6. Startups Attributes & Attacks
 *         - Each startup has core stats
 *              - Net Income (attack power)
 *              - Revenue (health)
 *              - Market share (defense)
 *         - Can perform 2-3 attacks  w/ unique characteristics
 *              - ex. 'x attack' (reduces opponent's Market Share / Net Income / Revenue)
 *         - attacks should have
 *              - a type advantage based on startup which grants % boost of attack
 *              - random chance to miss attack (0-15%), if not a miss
 *                   - random (0-50%) chance to double attack
 *      7. Experience & Evolution
 *         - Startups gain experience (XP) by winning
 *         - reaching specific XP levels allows them to evolve to higher stages : (example)
 *              - Level 1 : Garage Startup
 *              - Level 10 : 10+ Employees
 *              - Level 20 : Company
 *              - Level 50 : Household name
 *      8. Battle Mechanics
 *         - Battles are 1v1 (Startup vs Starup) w/ turn based actions (each player selects which startup to engage)
 *              - each startup attacks in turn with goal of reducing opponent's revenue to 0
 *              - if Startup revenue drops to 0, winning Tech Giant may buy or ignore
 *         - if a Tech giant has no startups left, it exits the simulation (announce results -> game over)
 *      9. Actions for Tech Giants
 *         - During turn Q4 Tech giants can Attack w/ 1 startup
 * 
 * Notes : 
 * (1v1 monopoly vs bot but startups generate $ and are affected by events each w/ unique attributes)
 * bot difficulty simple implementation [easy=playerType>botType, normal=playerType=botType, hard=playerType<botType]
 * Dead startups from battles should cost (startupLvl * costToRessurect) and when Ressurected should lose 2 levels if applicable
 * include run option (botLogic automatically chooses to run if startupHealth below 50%) which ends battle (stats update but no winner)
 * if opponent chooses to run then option presented to player 'pursue' with a 75% chance to keep the battle going or 'allow' which ends battle
 */
public class Assignment5 {
   public static void main(String[] args) { // placeholder
      System.out.println("Hello World");
   }
}
