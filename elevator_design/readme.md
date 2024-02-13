1. **Elevator System:**
   - Manages multiple elevators in the building.
   - Properties:
      - List of Elevators
   - Behaviors:
      - **`sendUpRequest(int elevatorIndex, Request request)`**
      - **`sendDownRequest(int elevatorIndex, Request request)`**
      - **`run()`**
2. **Elevator:**
   - Represents an individual elevator in the building.
   - Properties:
      - Current Floor
      - Direction
      - Up Queue
      - Down Queue
   - Behaviors:
      - **`sendUpRequest(Request upRequest)`**
      - **`sendDownRequest(Request downRequest)`**
      - **`run()`**
      - **`processRequests()`**
      - **`processUpRequest()`**
      - **`processDownRequest()`**
3. **Request:**
   - Represents a user request to move to a specific floor.
   - Properties:
      - Current Floor
      - Desired Floor
      - Direction
      - Location
4. **Location:**
   - Enum representing the location of the requester (inside or outside the elevator).
5. **Direction:**
   - Enum representing the direction of travel (up, down, or idle).
6. **Main:**
   - Contains the main method to demonstrate the elevator system.
   - Initializes the elevator system with a specified number of elevators and their initial floor.
   - Sends example requests to the elevator system for processing.
   - Starts the elevator system to continuously process requests.